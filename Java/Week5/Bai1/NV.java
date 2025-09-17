package Bai1;
import java.util.Scanner;
abstract public class NV {
    private String maNV;
    private String tenNV;
    private String trinhDo;
    private long luongCB;

    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public long getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(long luongCB) {
        this.luongCB = luongCB;
    }

    public NV(){
        maNV = null;
        tenNV = null;
        trinhDo = null;
        luongCB = 0l;
    }

    public NV(String maNV, String tenNV, String trinhDo, long luongCB){
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.trinhDo = trinhDo;
        this.luongCB = luongCB;
    }

    public NV(NV obj){
        this.maNV = obj.maNV;
        this.tenNV = obj.tenNV;
        this.trinhDo = obj.trinhDo;
        this.luongCB = obj.luongCB;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        tenNV= sc.nextLine();
        System.out.print("Nhap trinh do: ");
        trinhDo = sc.nextLine();
        System.out.print("Nhap luong co ban: ");
        luongCB = sc.nextLong();
    }

    public void xuat(){
        System.out.printf("| %-10s | %-20s | %-10s | %-10d |",maNV,tenNV,trinhDo,luongCB);
    }

    abstract public long tinhLuong();
}
