// ---------------------------
// Lấy danh sách blog
// ---------------------------
const fetchData = async() => {
    const res = await fetch("http://localhost:8000/blogs");
    const data = await res.json();

    const tbody = document.querySelector("#blogs tbody");
    tbody.innerHTML = "";
    if(data && data.length) {
        data.forEach((blog , index) => {
            tbody.innerHTML += `
            <tr>
                <td>${blog.id}</td>
                <td> ${blog.title}</td>
                <td> ${blog.author}</td>
                <td> ${blog.content}</td>
                <td> <button data-id= ${blog.id} class="btn-delete">Xoa</button></td>
            </tr>
            `
        });
    }
}

// ---------------------------
// Thêm blog mới
// ---------------------------
const handleNewBlogs = () => {
    const title = document.getElementById("inTitle");
    const author = document.getElementById("inAuthor");
    const content = document.getElementById("inContent");
    const btnSubmit = document.getElementById("btnSubmit");
    
    btnSubmit.addEventListener("click", async() => {
    
    const rawResponse = await fetch('http://localhost:8000/blogs', {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: rdId(100000000,999999999), 
            title: title.value , 
            author: author.value , 
            content: content.value })
        });
        const data = await rawResponse.json();
        addNewRowToEnd(data);
         // Gắn lại event xóa cho nút mới
        handleDeleteForButton (document.querySelector(`button[data-id='${data.id}']`))
        // Xóa nội dung ô input
        title.value = "";
        author.value = "";
        content.value = "";
    })
}
// ---------------------------
// Tạo ID ngẫu nhiên
// ---------------------------
function rdId(min,max)  {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1 )) + min;
};
// ---------------------------
// Thêm dòng mới vào bảng
// ---------------------------
const addNewRowToEnd = (blog) => {
    const newRow = document.createElement('tr');
    const tableBody = document.querySelector("#blogs tbody");

    newRow.innerHTML = `
        <tr>
                <td>${blog.id}</td>
                <td> ${blog.title}</td>
                <td> ${blog.author}</td>
                <td> ${blog.content}</td>
                <td> <button data-id= ${blog.id} class="btn-delete">Xoa</button></td>
        </tr>
    `;
    tableBody.appendChild(newRow);
    
}

// Hàm gắn event delete cho từng nút
const handleDeleteForButton = (btn) => {
  btn.addEventListener("click", async (event) => {
    const id = btn.getAttribute("data-id");

    await fetch(`http://localhost:8000/blogs/${id}`, {
      method: "DELETE",
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
      },
    });

    const row = event.target.closest("tr");
    row.remove();
  });
};
// Gắn event delete cho tất cả nút hiện có
const handleDeleteblog = () => {
    const btns = document.querySelectorAll(".btn-delete");
    btns.forEach(handleDeleteForButton);
}

fetchData().then(() => {
    handleDeleteblog();
});
handleNewBlogs();


