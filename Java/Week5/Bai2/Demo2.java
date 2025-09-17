package Bai2;
import java.util.Scanner;


public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HOCVIEN dshv = new HOCVIEN();
        

        dshv.init();
        do{
            System.out.println("=================Menu================");
        }while();
        System.out.print("1: Nhan vien quan ly, 2: nhan vien nghien cuu , 3: nhan vien phuc vu. Hay chon loai: ");
        byte loai = sc.nextByte();
        
        if (loai== 1) dshv.xuatTheoLoai(loai);
            else if(loai == 2) dshv.xuatTheoLoai(loai);
                else dshv.xuatTheoLoai(loai);
        
        


        sc.close();
    }
} 
