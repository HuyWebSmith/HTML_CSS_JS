console.log("Lab02");

const diemTB = (toan,van,anh) => {
    return (toan+van+anh) / 3;
}

const xepLoai = (diemTB) => {
    let kq;
    if (diemTB > 9 && diemTB <= 10) {
        kq = "Xuất Sắc";
    } else if (diemTB > 8 && diemTB <= 9) {
        kq = "Giỏi";
    } else if (diemTB > 6.5 && diemTB <= 8) {
        kq = "Khá";
    } else {
        kq = "Trung Bình";
    }
    return kq
}
const toan = 9; 
const van = 8;
const anh = 7;
const myTB = diemTB(toan,van,anh)


console.log(`Diem trung binh: ${diemTB(toan,van,anh)}
Xep loai: ${xepLoai(myTB)}`);