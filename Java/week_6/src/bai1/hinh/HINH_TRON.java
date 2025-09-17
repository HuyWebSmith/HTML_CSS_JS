package bai1.hinh;

import java.util.Scanner;

public class HINH_TRON implements HINH{
    private float banKinh;

    public HINH_TRON(){
        this.banKinh = 0;
    }

    public HINH_TRON(float banKinh){
        this.banKinh = banKinh;
    }

    public HINH_TRON(HINH_TRON obj){
        this.banKinh = obj.banKinh;
    }

    public float getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(float banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ban kinh hinh tron: ");
        banKinh = sc.nextFloat();
        
    }

    @Override
    public void xuat(){
        System.out.printf("\nHinh tron co ban kinh: %.2f",banKinh);
        
    }

    @Override
    public float dienTich(){
        return banKinh * banKinh * PI;
    }

}
