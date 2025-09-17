
var fullName = 'Nguyen Quang Huy';
var age = 26;
//** */  Hàm Built-in
/**
 //1. alert : OK hop thoai message
alert(fullName);
alert(age);

//2. Console
console.log('Day la mot console');
console.error();

//3. confirm : Hop thoai co OK , cancel
confirm('Ban da du 18 chua?');

//4. prompt : Ngoai hop thoai con co o input de nhap du lieu
prompt('Ban da du 18 chua?');

//5. set timeout : chay 1 doan code sau mot khoang thoi gian duoc khai bao
setTimeout(function() {
    alert('Thong bao');
},1000)

//6. set interval khong nhu set timeout chay 1 lan roi ngung thi cai nay chay lien tuc moi thoi gian khai bao
setInterval(function() {
    alert('Thong bao');
},1000)
 */

// var a = 2;
// var b = 3;
// var c = 3;
// var result = 'C' &&  a < b && 'A';

// console.log(result);

//* String */
//Doi tuong string ( dai dong ,  tra ve kieu du lieu object)
// var fullName = new String('Quang Huy')
// console.log(fullName);

/* back flash (xuat "" ,'' , \ )*/
// var fullName = new String('Quang Huy \'adddd\'');
/* kiem tra do dai 1 chuoi */
// console.log(fullName.length);

/*template string*/
// var firstName = 'Quang'
// var lastName = 'Huy'
// var price = 10;
// var VAT = 0.25;
// console.log(`Toi la " ${firstName} ${lastName}`
//     + ` Total: ${(price * (1 + VAT)).toFixed(2)}`);
//! cho phep ",' khong can backslash va bieu thuc tinh toan o trong
//! truyen parameter vao nho them $

//* String method */
var myString = 'Hoc JS can ban!';
//1 . length (do dai chuoi)
// console.log(myString.length);

//2. find index tim vi tri cua 1 ky tu , neu kh thay tra -1
// tr ve vi tri dau tien
// console.log(myString.indexOf('JS','vi tri bat dau tim kiem'));
// lastIndexOf()

//Tim kiem theo bieu thuc chinh quy
//search()

//3. Cut string 
// console.log(myString.slice('vi tri bat dau', ' vi tri ket thuc'));
// cat tu duoi thi vi tri bat dau la end tu phai sang trai giam dan -1 -2

//4. Replace (thay the chuoi)
// console.log(myString.replace('JS','Javascript'));

//5. upper case 
// console.log(myString.toUpperCase());

//6.lower case
// console.log(myString.toLowerCase());

//7.Trim
//Loai bo khoang trang thua o 2 dau
// console.log(myString.trim());

//8. split
// cat 1 chuoi thanh array
// var languages = 'Javascript, PHP, Ruby';
// console.log(languages.split(', ')); // truyen vao diem chung
//neu truyen vao chuoi trong se tach ra tung chu

//9. lay 1 ky tu bang vi tri
// const myString2 = 'Quang Huy'
// console.log(myString2.charAt(1));
// co the console.log(myString2['index']);

//* Number */
// C1 (nen dung)
// var age = 18;
// var PI = 3.148958585389585853;
// var number = 21;

//C2
// var otherNumber = new Number(9);
//NaN la dai dien cho 1 kieu so khong hop le
// kiem tra co phai bien co gia tri NaN kh dung isNaN()

/* lam viec voi number */
// .toString()

// lam tron so thap phan
//*! khi goi se bi chuyen ve kieu string
// console.log(PI.toFixed(2));
// console.log(typeof number.toString());
// console.log( number);

//** Array */
var languages = [
    'JavaScript',
    'PHP',
    'Ruby'
];
//1. to string
// console.log(languages.toString()); --> xuat cac chuoi ngan cach boi dau ,
//2. Join (neu muon ngan cach bang dau khac thi dung)
// bien array thanh 1 chuoi
// console.log(languages.join(' ki tu muon xuat de ngan cach'));
//3.pop ( xoa phan tu cuoi mang va tra phan tu da xoa)
//*! khi xoa het thi se tra ve undefined
// console.log(languages.pop())
//4.shift (xoa phan tu dau mang va tra phan tu da xoa)

//5.push (them 1 hoac nhieu phan tu vao cuoi mang va tra ve do dai moi cua mang)
// console.log(languages.push('Dart'))

//6.unshift() them 1 hoac nhieu phan tu vao dau mang va tra ve do dai moi cua mang
// console.log(languages.unshift('C++','C','Java'));

//7.splice(start index , so luong muon xoa //*!co the la 0)
//neu muon chen thi splice(start index , so luong muon xoa, element mun chen)
// tu thu 3 tro di la nhung element muon truyen vao

//8. concat
//console.log(array1.concat(array2));
// let text1 = "Hello";
// let text2 = "world!";
// let result = text1.concat(" ", text2);

//9. slice (cat element cua mang)
//console.log(langues.slice(start cut index ,end cut index));
// truyen so am vao de lay phan tu o cuoi mang

//* Function*/

// function sum(a,b) {
//     return a + b;
// };
// console.log(sum(5,4));


//Object
//them key bang bien
// var myEmail = 'email';
// var myInfo = {
//     name : 'Quang Huy',
//     age: 20,
//     address: 'TP.HCM,VN',
//     [myEmail]: 'quanghuy@gmail.com',
//     getName: function() {
//         return this.name;
//     }
// };
// var myKey = 'address'
// console.log(myInfo);
//them key 
// myInfo.email = 'nguyenquanghuy9.8h@gmail.com';
// lay value
// console.log(myInfo.name);
//c2
// console.log(myInfo[myKey]);
//xoa key
// delete.myInfo.age;

//** Object Constructor */

function User(firstName, lastName, avatar) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.avatar = avatar;
// doi tuong trong doi tuong
    this.getName = function() {
        return `${this.firstName} ${this.lastName} `;
    };
};

var author = new User('Quang','Huy','Avatar');
var user = new User('Huu','Thang','Avatar');

author.title = 'Chia se dao tai F8';
user.comment = 'Lieu co khoa asp.net kh ad ';


// User.prototype.className = '22DTHA1';

// console.log(author);
// console.log(user);
// console.log(author.getName());
// function Sum() {
//     let total = 0;
//     for(let i = 0; i < arguments.length; i++){
//         total += arguments[i];
//     }
//     return total;
// };

// console.log(Sum(1,2,3));

// var date = new Date();

// var day = date.getDate();
// var month = date.getMonth()+1;
// var year = date.getFullYear();

// console.log(`${day}/${month}/${year}`);

// var myInfo = {
//     name: 'Huy',
//     age: 20,
//     address: 'TPHCM'
// };

// for (var key in myInfo) {
//     console.log(key);
// }

var myCourses = [
    {
        id: 1,
        name: 'JavaScript',
        coin: 250
    },
    {
        id: 2,
        name: 'Html, Css',
        coin: 0
    },
    {
        id: 3,
        name: 'Ruby',
        coin: 0
    },
    {
        id: 4,
        name: 'PHP',
        coin: 400
    },
    {
        id: 5,
        name: 'ReactJS',
        coin: 500
    },
];
//*!call back
// myCourses.forEach(function(courses,index) {
//     console.log(index,courses);
// });

//Tat ca cac phan tu cua mang phai thoa mang 1 đk nào đó chỉ cần 1 cái sai thì trả ve false 
// var isFree = myCourses.every(function(course, index) {
//     return course.coin === 0;
// });
// console.log(isFree);

//chỉ cần 1 cái đúng thì trả ve true, nếu mà sai hết mới trả về false 
// var isFree = myCourses.some(function(course, index) {
//     return course.coin === 0;
// }); 
// console.log(isFree);

//Tim kiếm nếu element nào true sẽ trả về gán giá trị element true đó vào biến courses , luôn trả về một đối tượng 
// var courses = myCourses.find(function(course,index) {
//     return course.name === 'Ruby';
// });

//giống find nhưng sẽ trả về tất cả các element giống với điều kiện return 
//var listCourses = myCourses.filter(function(course,index) {
    //     return course.name === 'Ruby';
    // });

// console.log(courses);

var mapArray  = myCourses.map(function(course,index) {
    return {
        id: course.id,
        name:`'Khoa hoc: ${course.name}`,
        coin: course.coin,
        textCoin: `Gia: ${course.coin}`
    };
});
console.log(mapArray);

var myNumber = [1,2,[3,4],5,6,[7,8,9]];
//lam phang mang bang reduce
var flatArrays = myNumber.reduce(function(flatOutput,flatItem) {
    return flatOutput.concat(flatItem);
},[]);
console.log(flatArrays);

function Dog(name,color) {
    this.name = name;
    this.color = color;
    this.type = 'dong vat'
    
}
Dog.prototype.bark = () => {
    console.log('gau gau gau');
}
const dog1 = new Dog("Shiba","yellow");
const dog2 = new Dog("Alaska","Black");

console.log(dog1.name);
console.log(dog2.name);

console.log(dog1.type);
console.log(dog2.type);

console.log(dog1.bark);
console.log(dog2.bark);

console.log(dog1.bark === dog2.bark)