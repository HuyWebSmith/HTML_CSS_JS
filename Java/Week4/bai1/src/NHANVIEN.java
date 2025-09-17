import java.util.Scanner;


public class NHANVIEN extends CONNGUOI{
    private String luong;
    private String ngayNhanViec;
    private PHONGBANKHOA pbk = new PHONGBANKHOA();

    public NHANVIEN(){
        super();
        this.luong = null;
        this.ngayNhanViec = null;
    }


    public NHANVIEN(String hoTen,int namSinh,String luong,String ngayNhanViec,PHONGBANKHOA pbk){
        super(hoTen,namSinh);
        this.luong = luong;
        this.ngayNhanViec = ngayNhanViec;
        this.pbk = pbk;
    }

    public NHANVIEN(String hoTen,int namSinh,String luong,String ngayNhanViec,String maPBK,String tenPBK){
        super(hoTen,namSinh);
        this.luong = luong;
        this.ngayNhanViec = ngayNhanViec;
        this.pbk = new PHONGBANKHOA(maPBK, tenPBK);
    }

    public NHANVIEN(NHANVIEN obj){
        super(obj);
        this.luong = obj.luong;
        this.ngayNhanViec = obj.ngayNhanViec;
        this.pbk = obj.pbk;
    }

    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter Luong: ");
        luong = sc.nextLine();
        System.out.print("Enter ngay nhan viec: ");
        ngayNhanViec = sc.nextLine();
        
        pbk.input();
    }

    @Override
    public void output(){
        super.output();
        System.out.printf(" %-20s | %-20s |",luong,ngayNhanViec);
        pbk.output();
    }
}
