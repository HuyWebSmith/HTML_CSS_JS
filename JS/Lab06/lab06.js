const myBtnElement = document.getElementById("myBtn");
const myTextElement = document.getElementById("myText");
const backBtnElement = document.getElementById("backBtn");
const textBtnElement = document.getElementById("textBtn");

myBtnElement.addEventListener("click", () => {
    console.log("Click me");
    myTextElement.style.color = "red";
    myTextElement.style.backgroundColor = "green";
    alert("Text has changed");

});

backBtnElement.addEventListener("click", () => {
    
    myTextElement.style.color = "black";
    myTextElement.style.backgroundColor = "unset";
    console.log("Text changed back");
    alert("Text changed back");
});

