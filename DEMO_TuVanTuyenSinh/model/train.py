import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
import pickle

# Đọc dữ liệu
data = pd.read_csv("./data/major.csv")

# Chuẩn bị dữ liệu
X = data[['Min_Score', 'Job_Opportunity']]
y = data['Category']

# Chia dữ liệu
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Huấn luyện mô hình
model = DecisionTreeClassifier()
model.fit(X_train, y_train)

# Đánh giá mô hình
y_pred = model.predict(X_test)
print(f"Accuracy: {accuracy_score(y_test, y_pred):.2f}")

# Lưu mô hình
with open("model/trained_model.pkl", "wb") as f:
    pickle.dump(model, f)
