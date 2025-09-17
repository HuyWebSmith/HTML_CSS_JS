
import java.util.ArrayList;
import java.util.Scanner;
public class DEMO1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<HANGHOA> hh = new ArrayList<>();


        HANGHOA dm = new HANGDM();
        dm.nhap();
        dm.xuat();

        
        HANGHOA tp = new HANGTP();
        tp.nhap();
        tp.xuat();

        sc.close();
    }
}
