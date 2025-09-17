import java.util.Scanner;


public class HOCVIEN extends CONNGUOI{
    private float diem1;
    private float diem2;
    private float diem3;

    public HOCVIEN(){
        super();
        this.diem1 = 0;
        this.diem2 = 0;
        this.diem3 = 0;
    }

    public HOCVIEN(String hoTen,int namSinh , float diem1,float diem2,float diem3){
        super(hoTen,namSinh);
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public HOCVIEN(HOCVIEN obj){
        super(obj);
        this.diem1 = obj.diem1;
        this.diem2 = obj.diem2;
        this.diem3 = obj.diem3;
    }

    public float getDiem1() {
        return diem1;
    }

    public void setDiem1(float diem1) {
        this.diem1 = diem1;
    }

    public float getDiem2() {
        return diem2;
    }

    public void setDiem2(float diem2) {
        this.diem2 = diem2;
    }

    public float getDiem3() {
        return diem3;
    }

    public void setDiem3(float diem3) {
        this.diem3 = diem3;
    }

    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter point 1: ");
        diem1 = sc.nextFloat();
        System.out.print("Enter point 2: ");
        diem2 = sc.nextFloat();
        System.out.print("Enter point 3: ");
        diem3 = sc.nextFloat();
    }

    @Override
    public void output(){
        super.output();
        System.out.printf(" %.2f | %.2f | %.2f |",diem1,diem2,diem3);
    }
}
