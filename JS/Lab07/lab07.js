const user1 = {
    username: "quanghuy",
    password: "123"
};

const username = document.getElementById("inUsername");
const password = document.getElementById("inPassword");

const btnSignUp = document.getElementById("btnSignUp");

btnSignUp.addEventListener("click", () => {
    if(username.value === user1.username && password.value === user1.password) {
        alert("Dang nhap thanh cong");
        localStorage.setItem("username", JSON.stringify(username.value));
        localStorage.setItem("password", JSON.stringify(password.value));
        window.location.href = "./succes.html";
    }
    else {
        alert("Tai khoan hoac mat khau sai");
        inUsername.style.borderColor = "red";
        inPassword.style.borderColor = "red";
    }
});
