import pandas as pd
import matplotlib.pyplot as plt
from pymongo import MongoClient
import psycopg2
import time

# Đọc file CSV
df = pd.read_csv("traffic_data.csv")

# Clone dữ liệu tránh trùng khi test nhiều lần
df_mongo = df.copy()
df_pg = df.copy()

# ========== MongoDB ==========
mongo_client = MongoClient("mongodb://localhost:27017/")
mongo_db = mongo_client["traffic_db"]
mongo_col = mongo_db["traffic_data"]

# Xoá dữ liệu cũ nếu có
mongo_col.delete_many({})

# Ghi dữ liệu & đo thời gian MongoDB
start_mongo_insert = time.time()
mongo_col.insert_many(df_mongo.to_dict("records"))
end_mongo_insert = time.time()

# Truy vấn MongoDB & đo thời gian
start_mongo_query = time.time()
mongo_data = pd.DataFrame(list(mongo_col.find()))
mongo_grouped = mongo_data.groupby("location")["vehicle_count"].sum()
end_mongo_query = time.time()

print("\n🚦 MongoDB Vehicle Counts by Location:")
print(mongo_grouped)

# ========== PostgreSQL ==========
pg_conn = psycopg2.connect(
    database="traffic_db",
    user="postgres",
    password="123456",
    host="localhost",
    port="5432"
)
cur = pg_conn.cursor()

# Xoá dữ liệu cũ nếu có
cur.execute("DELETE FROM traffic_data")
pg_conn.commit()

# Ghi dữ liệu & đo thời gian PostgreSQL
start_pg_insert = time.time()
for _, row in df_pg.iterrows():
    cur.execute("""
        INSERT INTO traffic_data (location, time, vehicle_count)
        VALUES (%s, %s, %s)
    """, (row["location"], row["time"], row["vehicle_count"]))
pg_conn.commit()
end_pg_insert = time.time()

# Truy vấn PostgreSQL & đo thời gian
start_pg_query = time.time()
cur.execute("SELECT location, SUM(vehicle_count) FROM traffic_data GROUP BY location")
rows = cur.fetchall()
end_pg_query = time.time()

print("\n🚦 PostgreSQL Vehicle Counts by Location:")
for row in rows:
    print(f"{row[0]}: {row[1]}")

# ========== Hiển thị thời gian ==========
mongo_insert_time = end_mongo_insert - start_mongo_insert
pg_insert_time = end_pg_insert - start_pg_insert
mongo_query_time = end_mongo_query - start_mongo_query
pg_query_time = end_pg_query - start_pg_query

print(f"\n🕒 Insert Time - MongoDB: {mongo_insert_time:.4f}s | PostgreSQL: {pg_insert_time:.4f}s")
print(f"🕒 Query Time  - MongoDB: {mongo_query_time:.4f}s | PostgreSQL: {pg_query_time:.4f}s")

# ========== Vẽ biểu đồ so sánh ==========
labels = ['Insert Time', 'Query Time']
mongodb_times = [mongo_insert_time, mongo_query_time]
postgres_times = [pg_insert_time, pg_query_time]

x = range(len(labels))
plt.bar(x, mongodb_times, width=0.4, label='MongoDB', align='center', color='green')
plt.bar([i + 0.4 for i in x], postgres_times, width=0.4, label='PostgreSQL', align='center', color='blue')
plt.xticks([i + 0.2 for i in x], labels)
plt.ylabel("Seconds")
plt.title("MongoDB vs PostgreSQL - Performance Comparison")
plt.legend()
plt.tight_layout()
plt.show()

# Đóng kết nối
cur.close()
pg_conn.close()
