console.log("lab03");

const names = ["quanghuy" ,"hoidanit" , "eric" , "bla bla"]


console.log(names);

names.push(true,123);
console.log(names);

names.unshift(null);
console.log(names);

// names.pop();
// names.shift();
console.log(names);


const myClass = ["hoidanIT","eric","hung ","name", "bla bla"];
console.log(myClass,myClass.length);
for(let i=0 ; i < myClass.length ; i++ ){
    console.log("i = " , i , " and value = ",myClass[i]);
    
}

console.log("=========");
// myClass.forEach(function(value,index){
//     console.log("value = ",value, " index = ",index);
// });

myClass.forEach((value,index) => {
    console.log("value = ",value, " index = ",index);
});

console.log("==========");
const scores = [10,8,3,7,5];

scores.forEach((value,index) => {
    console.log(" index = ",index , "value = ",value );
});
console.log("==========");
// const scorex2 = scores.map((element,index) => {
//     return element * 2 ;
// });

// const otherScorex2 = scores.map((element,index) => element + 2);
// console.log(scores);
// console.log(scorex2);
// console.log(otherScorex2);


console.log("=======");
const ages = [10,20,30,25,12,19];

const agesX2 =  ages.map((item,index) => {
    return item * 2;
});

const agesGreatThan18 = ages.filter((item,index) => {
    return item > 18;
});
console.log("original: ",ages);
console.log("age x2: ",agesX2);
console.log("age great than 18: ",agesGreatThan18);






