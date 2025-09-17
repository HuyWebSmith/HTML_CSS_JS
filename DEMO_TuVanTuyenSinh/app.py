from flask import Flask, request, jsonify
import json
from flask_cors import CORS
from sklearn.neighbors import KNeighborsClassifier
from sklearn.preprocessing import LabelEncoder
import numpy as np

app = Flask(__name__)
CORS(app, resources={r"/*": {"origins": "*"}})

# Hàm tải dữ liệu trường học từ file JSON
def load_schools(file_path='schools.json'):
    with open(file_path, 'r', encoding='utf-8') as f:
        return json.load(f)

# Hàm chuyển đổi thu nhập thành điểm
def map_income_to_score(income_str):
    income_map = {
        '1 triệu': 5,
        '2 triệu': 6,
        '3 triệu': 7,
        '5 triệu': 8,
        '10 triệu': 9
    }
    return income_map.get(income_str, 0)

# Tiền xử lý và chuyển đổi dữ liệu
def preprocess_schools(schools):
    fields = ['Kinh tế', 'Quản trị kinh doanh', 'Tài chính', 'Marketing', 'Kinh doanh quốc tế', 'Ngoại thương', 'Kinh tế đối ngoại', 'Giáo dục', 'Sư phạm toán', 'Sư phạm tiếng Anh', 'Giáo dục tiểu học', 'Công nghệ thông tin', 'Kỹ thuật điện tử', 'Kỹ thuật cơ khí', 'Vật liệu', 'Xã hội học', 'Nhân học', 'Tâm lý học', 'Ngôn ngữ học', 'Thiết kế đồ họa', 'An toàn thông tin', 'Răng hàm mặt', 'Điều dưỡng', 'Kiến trúc', 'Kỹ thuật phần mềm', 'Thiết kế thời trang']
    personality = ['Lãnh đạo', 'Sáng tạo', 'Lạc quan', 'Chăm chỉ', 'Tận tâm', 'Năng động', 'Tư duy phản biện', 'Nhạy bén', 'Kỹ lưỡng', 'Chăm sóc']

    # Mã hóa "fields" và "personality_fit" thành các cột nhị phân
    for school in schools:
        for field in fields:
            school[field] = 1 if field in school['fields'] else 0
        for trait in personality:
            school[trait] = 1 if trait in school['personality_fit'] else 0

    # Mã hóa "location" thành số
    location_encoder = LabelEncoder()
    locations = [school['location'] for school in schools]
    location_encoder.fit(locations)
    
    for school in schools:
        school['location_encoded'] = location_encoder.transform([school['location']])[0]
    
    return schools, fields, personality, location_encoder

# Hàm huấn luyện mô hình KNN
def train_knn(schools, fields, personality):
    # Xây dựng dữ liệu đầu vào và nhãn
    X = []
    y = []
    
    for school in schools:
        # Tạo vector đặc trưng cho mỗi trường
        features = [school[field] for field in fields] + [school[trait] for trait in personality] + [school['tuition'], school['score']]
        X.append(features)
        y.append(school['location_encoded'])  # Nhãn là location đã mã hóa
    
    # Chuyển dữ liệu thành numpy array
    X = np.array(X)
    y = np.array(y)

    # Khởi tạo và huấn luyện mô hình KNN
    knn = KNeighborsClassifier(n_neighbors=3)
    knn.fit(X, y)
    
    return knn

# API tư vấn
# API tư vấn
@app.route('/advisory', methods=['POST'])
def advisory():
    data = request.json
    score = data['score']
    interests = data['interests']
    location = data['location']
    personality = data['personality']
    income = data['income']

    # Trọng số tiêu chí
    weights = {
        'score': 0.3,
        'interests': 0.25,
        'location': 0.25,
        'personality': 0.1,
        'income': 0.1
    }

    # Lấy dữ liệu trường học và tiền xử lý
    schools = load_schools()  # Lấy dữ liệu trường học từ JSON
    schools, fields, personality, location_encoder = preprocess_schools(schools)
    
    # Huấn luyện mô hình KNN
    knn = train_knn(schools, fields, personality)

    # Chuyển đổi đầu vào người dùng thành vector đặc trưng
    user_features = []
    for field in fields:
        user_features.append(1 if any(f in interests for f in [field]) else 0)
    for trait in personality:
        user_features.append(1 if any(t in personality for t in [trait]) else 0)
    
    income_score = map_income_to_score(income)
    user_features.append(income_score)  # Điểm thu nhập
    user_features.append(score)  # Điểm của người dùng
    
    # Dự đoán trường học phù hợp
    predicted_location_encoded = knn.predict([user_features])
    predicted_location = location_encoder.inverse_transform(predicted_location_encoded)

    # Tính toán điểm cho từng trường học
    results = []
    for school in schools:
        total_score = 0
        # Tính điểm cho từng trường học
        if score >= school['score']:
            total_score += score * weights['score']
        if any(field in interests for field in school['fields']):
            total_score += 1 * weights['interests']
        if school['location'] == location:
            total_score += 1 * weights['location']
        if any(trait in personality for trait in school['personality_fit']): 
            total_score += 1 * weights['personality']
        
        income_score = map_income_to_score(income)
        if school['tuition'] <= income_score:
            total_score += 1 * weights['income']
        
        results.append({
            'school': school['name'],
            'score': total_score,
            'location': school['location']  # Để xác định khu vực khi cần
        })

    # Sắp xếp các trường học theo điểm số giảm dần
    results = sorted(results, key=lambda x: x['score'], reverse=True)

    # Giải quyết tình huống nếu điểm bằng nhau (tie-breaker)
    if len(results) > 1 and results[0]['score'] == results[1]['score']:
        # Nếu điểm bằng nhau và người dùng chọn TP.HCM, ưu tiên trường ở TP.HCM
        if location == "Hồ Chí Minh":
            for result in results:
                if result['location'] == "Hồ Chí Minh":
                    result['score'] += 0.05  # Bonus điểm cho trường ở TP.HCM
                    break  # Chỉ cần cộng điểm cho một trường ở TP.HCM
        elif location == "Hà Nội":
            for result in results:
                if result['location'] == "Hà Nội":
                    result['score'] += 0.05  # Bonus điểm cho trường ở Hà Nội
                    break  # Chỉ cần cộng điểm cho một trường ở Hà Nội

    return jsonify(results)


# Đọc file JSON và trả về danh sách trường
def load_schools():
    with open('schools.json', 'r', encoding='utf-8') as f:
        return json.load(f)

@app.route('/school_details', methods=['GET'])
def school_details():
    school_name = request.args.get('school')
    schools = load_schools()

    # Tìm trường theo tên
    school = next((s for s in schools if s['name'] == school_name), None)

    if school:
        return jsonify(school)
    else:
        return jsonify({'error': 'Trường không tìm thấy'}), 404

if __name__ == '__main__':
    app.run(debug=True)
