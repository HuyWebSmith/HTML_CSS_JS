package Bai1;
import java.util.Scanner;
public class NVQL extends NV{
    private String chuyenMon;
    private long phuCapCV;

    
    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public long getPhuCapCV() {
        return phuCapCV;
    }

    public void setPhuCapCV(long phuCapCV) {
        this.phuCapCV = phuCapCV;
    }

    public NVQL(){
        super();
        chuyenMon = null;
        phuCapCV = 0l;
    }

    public NVQL(String maNV,String tenNV,String trinhDo,long luongCB,String chuyenMon, long phuCapCV){
        super(maNV,tenNV,trinhDo,luongCB);
        this.chuyenMon = chuyenMon;
        this.phuCapCV = phuCapCV;
    }

    public NVQL(NVQL obj){
        super(obj);
        this.chuyenMon = obj.chuyenMon;
        this.phuCapCV = obj.phuCapCV;
    }

    @Override
    public void nhap(){
        Scanner sc =new Scanner(System.in);
        super.nhap();
        System.out.print("Nhap chuyen mon: ");
        chuyenMon = sc.nextLine();
        System.out.print("Nhap phu cap cong viec: ");
        phuCapCV = sc.nextLong();
        sc.close();
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.printf(" %-10s | %-10d |",chuyenMon,phuCapCV );
        System.out.println();
    }

    @Override
    public long tinhLuong(){
        return getLuongCB() + phuCapCV;
    }
}
