import java.util.Scanner;

public class PHONGBANKHOA{
    private String maPBK;
    private String tenPBK;

    public PHONGBANKHOA(){
        
        this.maPBK = null;
        this.tenPBK = null;
    }

    public PHONGBANKHOA(String maPBK,String tenPBK){
        this.maPBK = maPBK;
        this.tenPBK = tenPBK;
    }

    public PHONGBANKHOA(PHONGBANKHOA obj){
        this.maPBK = obj.maPBK;
        this.tenPBK = obj.tenPBK;
    }

    public String getMaPBK() {
        return maPBK;
    }

    public void setMaPBK(String maPBK) {
        this.maPBK = maPBK;
    }

    public String getTenPBK() {
        return tenPBK;
    }

    public void setTenPBK(String tenPBK) {
        this.tenPBK = tenPBK;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\nEnter PBK code: ");
        maPBK = sc.nextLine();
        System.out.print("Enter PBK name: ");
        tenPBK = sc.nextLine();
    }

    public void output(){
        System.out.printf(" %-15s | %-15s |",maPBK,tenPBK);
    }
}
