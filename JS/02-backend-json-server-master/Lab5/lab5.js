const fetchData = async() => {
    const res =  await fetch("http://localhost:8000/users");
    const data = await res.json();
    if(data && data.length) {
            data.forEach((user,index) => {
            const tbodyData = document.querySelector("#users tbody");
            tbodyData.innerHTML += 
            `<tr>
            <td>${data[index].id}</td>
            <td> ${data[index].name}</td>
            <td> ${data[index].email}</td>
            </tr>`
        });
    }
};
fetchData();