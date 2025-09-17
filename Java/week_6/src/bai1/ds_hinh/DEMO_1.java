package bai1.ds_hinh;
import bai1.hinh.*;

import java.util.Scanner;


public class DEMO_1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        DS_HINH h = new DS_HINH();
        boolean count = true;
        do{
            HINH hv = new HINH_VUONG();
            HINH hcn = new HINH_HCN();
            HINH ht = new HINH_TRON();
            System.out.println("=============Menu=============");
            System.out.println("=      1: Hinh vuong         =");
            System.out.println("=      2: Hinh chu nhat      =");
            System.out.println("=      3: Hinh tron          =");
            System.out.println("=      4: Xuattheo loai      =");
            System.out.println("=      0: Thoat              =");
            System.out.println("==============================");

            System.out.print("Nhap chuc nang: ");
            byte chon ;
            chon = sc.nextByte();
            System.out.printf("Ban da chon chuc nang: " + chon + "\n");
            System.out.print("Loading");
            System.out.print("\rLoading."); 
            System.out.print("\rLoading.."); 
            System.out.print("\rLoading..."); 
            System.out.println("\nComplete!");
            switch (chon) {
                case 1:
                    hv.nhap();
                    h.them(hv);

                    break;
            
                case 2:
                    hcn.nhap();
                    h.them(hcn);
                    break;
                
                case 3:
                    
                    ht.nhap();
                    h.them(ht);
                    break;

                case 4: 
                    System.out.println("=      1: Hinh vuong         =");
                    System.out.println("=      2: Hinh chu nhat      =");
                    System.out.println("=      3: Hinh tron          =");
                    System.out.print("Nhap loai hinh can xuat: ");
                    int loai = sc.nextInt();
                    
                    h.xuatTheoLoai(loai);
                    
                    break;
                
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }while(count);
        sc.close();
    }
}
