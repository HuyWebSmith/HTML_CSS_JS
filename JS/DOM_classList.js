let elm = document.getElementById("myElement");

//1. Them 1 class moi
elm.classList.add("newClass");
//2. Kiem tra xem phan tu co chua lop cu the khong
console.log(elm.classList.contains("myClass"));
//3. Xoa class
elm.classList.remove("myClass");
//4. thay the class
elm.classList.replace("newClass","abc");
// 5. Neu class da ton tai loai bo no, neu kh ton tai them moi 
elm.classList.toggle("toggleClass");
//6. Kiem tra class
console.log(elm.classList);