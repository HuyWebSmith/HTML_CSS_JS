
import java.util.Scanner;

public class HANGHOA{
    protected String maHang;
    protected String tenHang;
    protected double donGia;

    public HANGHOA(){
        
    }

    public HANGHOA(String maHang , String tenHang , double donGia){
        this.maHang = maHang; 
        this.tenHang = tenHang;
        this.donGia = donGia;
    }

    public HANGHOA(HANGHOA obj){
        this.maHang = obj.maHang; 
        this.tenHang = obj.tenHang;
        this.donGia = obj.donGia;
    }

    
    public void nhap(){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter product code: ");
        maHang = sc.nextLine();
        System.out.print("Enter product name: ");
        tenHang = sc.nextLine();
        System.out.print("Enter product $: ");
        donGia = sc.nextLong();
    }
}