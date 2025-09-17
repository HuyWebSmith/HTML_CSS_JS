document.getElementById('advisoryForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    // Thu thập dữ liệu từ form
    const formData = {
        score: parseFloat(document.getElementById('score').value),
        interests: document.getElementById('interests').value.split(','),
        location: document.getElementById('location').value,
        personality: document.getElementById('personality').value.split(','),
        income: document.getElementById('income').value
    };

    // Gửi yêu cầu tới Flask backend
    const response = await fetch('http://localhost:5000/advisory', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    });

    // Kiểm tra phản hồi từ server
    if (!response.ok) {
        console.error('Lỗi phản hồi từ server:', response.statusText);
        return;
    }

    const results = await response.json();

    // Hiển thị kết quả lên bảng
    const resultTable = document.getElementById('resultTable').getElementsByTagName('tbody')[0];
    
    // Xóa các kết quả cũ trước khi thêm mới
    resultTable.innerHTML = '';

    // Thêm các kết quả mới vào bảng
    results.forEach(r => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${r.school}</td>
            <td>${r.score.toFixed(2)}</td>
            
        `;
        resultTable.appendChild(row);
    });
    
});
