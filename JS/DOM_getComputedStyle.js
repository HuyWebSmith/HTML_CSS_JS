let heading =document.querySelector("h1")
heading.style.backgroundColor = "cyan";
heading.style.fontSize = "46px";
heading.style.color = "red";

Object.assign(heading.style,{
    backgroundColor: "cyan",
    fontSize: "46px",
    color: "red"
})

let h1 = document.querySelector("h1");
window.getComputedStyle(h1.backgroundColor);
console.log(h1.style.backgroundColor);


