package bai1.hinh;

import java.util.Scanner;

public class HINH_HCN implements HINH{
    private float dai;
    private float rong;

    public HINH_HCN(){
        this.dai = 0;
        this.rong = 0;
    }

    public HINH_HCN(float dai, float rong){
        this.dai = dai;
        this.rong = rong;
    }

    public HINH_HCN(HINH_HCN obj){
        this.dai = obj.dai;
        this.rong = obj.rong;
    }

    

    public float getDai() {
        return dai;
    }

    public void setDai(float dai) {
        this.dai = dai;
    }

    public float getRong() {
        return rong;
    }

    public void setRong(float rong) {
        this.rong = rong;
    }

    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai hinh chu nhat: ");
        dai = sc.nextFloat();
        System.out.print("Nhap chieu rong hinh chu nhat: ");
        rong = sc.nextFloat();
        
    }

    @Override
    public void xuat(){
        System.out.printf("\nHinh vuong co chieu dai %.2f va chieu rong %.2f",dai,rong);
        
    }

    @Override
    public float dienTich(){
        return dai * rong;
    }

}
