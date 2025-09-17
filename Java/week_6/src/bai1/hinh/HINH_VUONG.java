package bai1.hinh;

import java.util.Scanner;

public class HINH_VUONG  implements HINH{
    private float canh;
    
    public HINH_VUONG(){
        this.canh = 0;
    }

    public HINH_VUONG(float canh){
        this.canh = canh;
    }

    public HINH_VUONG(HINH_VUONG obj){
        this.canh = obj.canh;
    }

    public float getCanh() {
        return canh;
    }

    public void setCanh(float canh) {
        this.canh = canh;
    }

    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap canh hinh vuong: ");
        canh = sc.nextFloat();
    }

    @Override
    public void xuat(){
        System.out.printf("| %-8.2f|",canh);
    }

    @Override
    public float dienTich(){
        return canh * canh;
    }
    

}
