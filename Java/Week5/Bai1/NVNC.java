package Bai1;
import java.util.Scanner;
public class NVNC extends NV{
    private String chuyenMon;
    private long phuCapDH;

    public NVNC(){
        super();
        chuyenMon = null;
        phuCapDH = 0l;
    }

    public NVNC(String maNV,String tenNV,String trinhDo,long luongCB,String chuyenMon, long phuCapDH){
        super(maNV,tenNV,trinhDo,luongCB);
        this.chuyenMon = chuyenMon;
        this.phuCapDH = phuCapDH;
    }

    public NVNC(NVNC obj){
        super(obj);
        this.chuyenMon = obj.chuyenMon;
        this.phuCapDH = obj.phuCapDH;
    }

    @Override
    public void nhap(){
        Scanner sc =new Scanner(System.in);
        super.nhap();
        System.out.print("Nhap chuyen mon: ");
        chuyenMon = sc.nextLine();
        System.out.print("Nhap phu cap doc hai: ");
        phuCapDH = sc.nextLong();
        sc.close();
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.printf(" %-10s | %-10d |",chuyenMon,phuCapDH );
        System.out.println();
    }

    @Override
    public long tinhLuong(){
        return getLuongCB() + phuCapDH;
    }
}
