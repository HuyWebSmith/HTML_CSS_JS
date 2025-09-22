// let heading = document.firstElementChild.lastElementChild.firstElementChild;
// console.log(heading);
// heading.innerHTML = "Tôi đang đợi xem DOM có gì hay không?";

// console.log(`getElementsByTagName: `);
// let li_item = document.getElementsByTagName("li");
// console.log(li_item);
// console.log(li_item.length);
// li_item[2].innerHTML = "aaaaaaaaaa";


// //4.getElementsByClassName
// console.log("getElementsByClassName:");

// let li_class_item = document.getElementsByClassName("list");
// console.log(li_class_item);
// li_class_item[1].innerHTML = "2222";

//4.5
// let el = document.getElementById("list_about");
// console.log(el);
// el.innerHTML = "See about me";


//6. QuerySelector
// let checkBox = document.querySelector("input");
// checkBox.checked = true;
// let title = document.querySelector("#heading_title");
// console.log(title);
//7. QuerySelectorAll

// let list_li = document.querySelectorAll("ul li");
// list_li[2].innerHTML = " ddax thay doi"

//Date
function UpdateClock() {
    const now = new Date();
    // const hours = (now.getHours() < 10 ? "0" : "") + now.getHours();
    // const minutes =(now.getMinutes() < 10 ? "0" : "") + now.getMinutes();
    // const seconds =(now.getSeconds() < 10 ? "0" : "") + now.getSeconds();

    const hours = String(now.getHours()).padStart(2,"0");
    const minutes = String(now.getMinutes()).padStart(2,"0");
    const seconds = String(now.getSeconds()).padStart(2,"0");

    const timeString = `${hours}:${minutes}:${seconds}`;
    console.log(timeString);
    document.getElementById("clock").innerHTML = timeString;
}
setInterval(UpdateClock(),1000);