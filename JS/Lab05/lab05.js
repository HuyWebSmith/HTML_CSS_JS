const sp1 = {
    name: "Shirt",
    price: 100.000,
    inStock: true
};

const sp2 = {
    name: "Hoodie",
    price: 400.000,
    inStock: true
};

const sp3 = {
    name: "Pant",
    price: 100.000,
    inStock: false
};

const sp4 = {
    name: "Trouser",
    price: 200.000,
    inStock: true
};

const sp5 = {
    name: "Cap",
    price: 50.000,
    inStock: false
};

const sanpham = [sp1,sp2,sp3,sp4,sp5];

console.log(">>1. ",sanpham[0].name);

sanpham[1].price = 150.000 
console.log(">>>2. ",sanpham);

sanpham.push({
    name: "Underwear",
    price: 20.000,
    inStock: true
});
console.log(">>>3. ",sanpham);

sanpham.pop({
    name: "Underwear",
    price: 20.000,
    inStock: true
});
console.log(">>>4. ",sanpham);

sanpham.forEach((item,value) => {
    console.log(">>>5. ",item.name);
    
})

const giaSanPham = sanpham.map((item,value) => {
    return item.price;
});
console.log(">>>6. ",giaSanPham);

const spInStock  = sanpham.filter((item) => {
    return item.inStock === true;
});
console.log(">>>7. ",spInStock);

for(let key in sp1) {
    console.log(key,sp1[key]);
     
}


