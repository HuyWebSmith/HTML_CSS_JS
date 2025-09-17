
import java.util.Scanner;

public class CONNGUOI {
    private String hoTen;
    private int namSinh;

    public CONNGUOI(){
        this.hoTen = null;
        this.namSinh = 0;
    }

    public CONNGUOI(String hoTen,int namSinh){
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public CONNGUOI(CONNGUOI obj){
        this.hoTen = obj.hoTen;
        this.namSinh = obj.namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        hoTen = sc.nextLine();
        System.out.print("Enter Year of Birthday: ");
        namSinh = sc.nextInt();
    }

    public void output(){
        System.out.printf("| %-25s|    %d    |",hoTen,namSinh);
    }
}
