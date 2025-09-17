package Week2.bai3;
import java.util.Scanner;
public class Main {
    public void main(){
        Scanner sc = new Scanner(System.in);
        Location point1 = new Location();
        Location point2 = new Location(1,2);

        System.err.println("Point 1: ");
        point1.Input();

        System.err.println("..................");
        System.err.println("Point 2: ");
        point2.Input();

        System.err.println("..................");
        System.err.println("Sum: ");
        Location point3 = point1.sum(point2);
        point3.Output(point3);
        System.out.println();

        System.err.println("..................");
        System.err.println("Symmetry: ");
        point3.symmetry(point3);
        point3.Output(point3);
        sc.close();
    }
}
