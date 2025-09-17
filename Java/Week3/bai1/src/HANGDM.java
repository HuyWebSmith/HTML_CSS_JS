
import java.util.Scanner;

public class HANGDM extends HANGHOA {   
    private int thoiGianBH;
    private int dienAp;
    private int congSuat;


    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public int getDienAp() {
        return dienAp;
    }

    public void setDienAp(int dienAp) {
        this.dienAp = dienAp;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public HANGDM(){
        super();
    }

    public HANGDM(String maHang, String tenHang, double donGia, int thoiGianBH, int dienAp, int congSuat){
        super(maHang,tenHang,donGia);
        this.thoiGianBH = thoiGianBH;
        this.dienAp = dienAp;
        this.congSuat = congSuat;
    }

    public HANGDM(HANGDM obj){
        super(obj);
        this.thoiGianBH = obj.thoiGianBH;
        this.dienAp = obj.dienAp;
        this.congSuat = obj.congSuat;
    }

    @Override
    public void nhap(){
        Scanner sc =  new Scanner(System.in);
        super.nhap();
        System.out.print("Enter product code: ");
        thoiGianBH = sc.nextInt();
        System.out.print("Enter product name: ");
        tenHang = sc.nextLine();
        System.out.print("Enter product $: ");
        donGia = sc.nextLong();
    }

    
}
