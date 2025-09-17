package Week2.bai3;
import java.util.Scanner;
public class Location {
    public int x;
    public int y;

    //* default
    public Location(){
        this.x = 0;
        this.y = 0;
    }

    //* parameter
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    //*copy
    public Location(Location obj){
        this.x = obj.x;
        this.y = obj.y;
    }

    public void Input(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x: ");
        x= sc.nextInt();
        System.out.print("Enter y: ");
        y= sc.nextInt();
    }

    public void Output(Location point){
        System.out.print("[" + x + "," + y + "]");
    }
    public Location sum(Location l){
        Location s = new Location();
        s.x = x + l.x;
        s.y = y + l.y;
        return s;
    }

    public Location symmetry(Location symmetry){
        symmetry.x = x;
        symmetry.y = -y;
        return symmetry;
    }
}
