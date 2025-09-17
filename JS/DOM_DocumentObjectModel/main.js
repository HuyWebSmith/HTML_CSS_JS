let heading = document.firstElementChild.lastElementChild.firstElementChild;
console.log(heading);
heading.innerHTML = "Tôi đang đợi xem DOM có gì hay không?";

console.log(`getElementsByTagName: `);
let li_item = document.getElementsByTagName("li");
console.log(li_item);
console.log(li_item.length);
li_item[2].innerHTML = "aaaaaaaaaa";


//4.getElementsByClassName
console.log("getElementsByClassName:");

let li_class_item = document.getElementsByClassName("list");
console.log(li_class_item);
li_class_item[1].innerHTML = "2222";

//4.5
let el = document.getElementById("list_about");
console.log(el);
el.innerHTML = "See about me";


