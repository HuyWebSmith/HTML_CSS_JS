const myTodoVal =  document.getElementById("myTodo");
const btnSubmitTodo =  document.getElementById("submitTodo");
function getRandom(min,max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1 )) + min;
};
if(btnSubmitTodo){
        btnSubmitTodo.addEventListener("click",() =>{
        const myTodo = {
            id: getRandom(1,1000000000),
            name: myTodoVal.value
        }
        const curentTodoStr = localStorage.getItem("todo");
        
        if (curentTodoStr) {
            const curentTodo = JSON.parse(curentTodoStr);
            curentTodo.push(myTodo);
            localStorage.setItem("todo",JSON.stringify(curentTodo));
        }
        else {
            localStorage.setItem("todo",JSON.stringify([myTodo]));
        }
        //success
        window.location.href = "./lab6.html";
    });
}

const generateTodoList = () => {
    const todoListStr = localStorage.getItem("todo");
    if(todoListStr) {
        const todoList = JSON.parse(todoListStr);
        if(todoList && todoList.length) {
            todoList.forEach((todo,index) => {
            const tbodyData = document.querySelector("#todoList tbody");
            tbodyData.innerHTML +=
            `<tr>
            <td>${todo.id}</td>
            <td> ${todo.name}</td>
            <td> <button data-id= ${todo.id} class="btn-delete">Xoa</button></td>
            </tr>`
        });
    }
    }
    
};
generateTodoList();

const deleteBtns =  document.querySelectorAll(".btn-delete");
console.log(deleteBtns);
if(deleteBtns) {
    deleteBtns.forEach((btn , index) =>{
        btn.addEventListener("click",() => {
            const id = btn.getAttribute("data-id");
            handleDeleteTodo(id);
        })
    });
}

const handleDeleteTodo = (id) => {
    const todoListStr = localStorage.getItem("todo");
    if(todoListStr) {
        const todoList = JSON.parse(todoListStr);

        const newTodo = todoList.filter((todo,index) => todo.id + "" !== id);

        localStorage.setItem("todo",JSON.stringify(newTodo));
        window.location.reload();
    }
};
