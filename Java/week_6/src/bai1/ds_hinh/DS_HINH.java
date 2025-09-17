package bai1.ds_hinh;

import java.util.ArrayList;

import bai1.hinh.*;

public class DS_HINH {
    ArrayList<HINH> ds = new ArrayList<>();

    public void them(HINH e){
        ds.add(e);
    }

    public void xuatTheoLoai(int loai){
        if(loai == 1){
            System.out.println("Tinh dien tich hinh vuong.");
            System.out.printf("| %-7s | %-10s |","Canh","Dien tich");
            System.out.println();}
        for(HINH x : ds){
            if(x instanceof HINH_VUONG && loai ==1){
                x.xuat();
                System.out.printf(" %-10.2f |",x.dienTich());
                System.out.println();}
                
            if(x instanceof HINH_HCN && loai ==2){
                x.xuat();
                System.out.printf("\tDien tich: %.2f",x.dienTich());
                System.out.println();}
            if(x instanceof HINH_TRON && loai ==3){
                x.xuat();
                System.out.printf("Dien tich: %.2f",x.dienTich());
                System.out.println();}
        }
    }

    
}
