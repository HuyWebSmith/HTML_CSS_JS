
import java.util.Scanner;
public class HANGTP extends HANGHOA {
    private String ngaySX;
    private String ngayHH;

    public String getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(String ngaySX) {
        this.ngaySX = ngaySX;
    }

    public String getNgayHH() {
        return ngayHH;
    }

    public void setNgayHH(String ngayHH) {
        this.ngayHH = ngayHH;
    }

    public HANGTP(){
        super();
    }

    public HANGTP(String maHang,String tenHang,double donGia,String ngaySX,String ngayHH){
        super(maHang,tenHang,donGia);
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
    }
    public HANGTP(HANGTP obj){
        super(obj);
        this.ngaySX = obj.ngaySX;
        this.ngayHH = obj.ngayHH;
    }

    @Override
    public void nhap(){
        Scanner sc =  new Scanner(System.in);
        super.nhap();
        System.out.print("Enter ngay sx: ");
        ngaySX = sc.nextLine();
        System.out.print("Enter ngay hh: ");
        ngayHH = sc.nextLine();
    }

    
}
