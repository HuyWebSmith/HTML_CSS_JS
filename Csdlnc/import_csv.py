import psycopg2
import pandas as pd
from pymongo import MongoClient
import random
from datetime import datetime, timedelta

# Kết nối tới PostgreSQL
conn = psycopg2.connect(
    dbname="traffic_db",
    user="postgres",
    password="123456",   # 🔑 Đổi thành mật khẩu thật của bạn
    host="localhost",
    port="5432"
)

# Tạo bảng nếu chưa có
create_table_query = """
CREATE TABLE IF NOT EXISTS traffic_data (
    id SERIAL PRIMARY KEY,
    location VARCHAR(50),
    time TIMESTAMP,
    vehicle_count INT
);
"""

# Thực thi tạo bảng
cursor = conn.cursor()
cursor.execute(create_table_query)

# Xóa dữ liệu cũ trong PostgreSQL trước khi chèn dữ liệu mới
cursor.execute("DELETE FROM traffic_data")
conn.commit()  # Đảm bảo thay đổi được commit vào cơ sở dữ liệu


# Tạo danh sách địa điểm mẫu
locations = [f"Location_{i}" for i in range(1, 10001)]

#! Tạo dữ liệu giả lập 10000 
data = []
start_time = datetime(2025, 4, 15, 7, 0)

for location in locations:
    time = start_time  # Chỉ tạo dữ liệu cho 1 giờ
    vehicle_count = random.randint(50, 300)  # Số lượng xe ngẫu nhiên từ 50 đến 300
    data.append([location, time.strftime("%Y-%m-%d %H:%M"), vehicle_count])

# Chuyển thành DataFrame
df = pd.DataFrame(data, columns=["location", "time", "vehicle_count"])

# Ghi dữ liệu vào file CSV
df.to_csv("traffic_data.csv", index=False)
# # Đọc CSV
# df = pd.read_csv("traffic_data.csv")

# Ghi từng dòng vào bảng PostgreSQL
for _, row in df.iterrows():
    cursor.execute(
        "INSERT INTO traffic_data (location, time, vehicle_count) VALUES (%s, %s, %s)",
        (row['location'], row['time'], int(row['vehicle_count']))
    )

# Commit vào PostgreSQL
conn.commit()

# Kết nối đến MongoDB
client = MongoClient("mongodb://localhost:27017/")
db = client["traffic_db"]  # Tên database MongoDB
collection = db["traffic_data"]  # Tên collection MongoDB

# Xóa dữ liệu cũ trong MongoDB
collection.delete_many({})

# Chuyển đổi DataFrame thành list of dictionaries để import vào MongoDB
data = df.to_dict(orient="records")

# Chèn dữ liệu vào MongoDB
collection.insert_many(data)

# Đóng kết nối
cursor.close()
conn.close()
client.close()

print("✅ Dữ liệu đã được import thành công vào PostgreSQL và MongoDB.")
