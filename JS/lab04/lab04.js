const sv1 = {
    username: "hoidanit",
    score: 9.6
};
const sv2 = {
    username: "eric",
    score: 3
};
const sv3 = {
    username: "bla bla",
    score: 5
};

const sinhvien =[sv1,sv2,sv3];
console.log(">>>> Check Sinh Vien: ",sinhvien);

// sinhvien.forEach((item,index) => {
//     console.log(">>>>> index = " ,index, " name = ",item.username);
    
// });

const person = {
    email: "quanghuy@gmail.com",
    age: 25,
    address: "vietnam"
}
for (let key in person) {
    console.log(key, person[key]);
}
for (let value of Object.values(person)) {
    console.log(value);
}
