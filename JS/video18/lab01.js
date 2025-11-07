console.log("lab01");
const fullName = "eric noo noo noo";
const birthYear = 2000;

const today = new Date();
const currentYear = today.getFullYear();

console.log(currentYear,typeof currentYear);
let calculateYear = currentYear - birthYear;

function  isStudentF(calculateYear) {
    if(calculateYear >=20 && calculateYear <= 27){return true}
    else{
        return false
    }
}
console.log(`Ten : ${[fullName]}
Tuoi: ${[calculateYear]}
Sinh Vien: ${isStudentF(calculateYear)}`)
