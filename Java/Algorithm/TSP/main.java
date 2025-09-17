
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int v = scanner.nextInt();
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = scanner.nextInt();
            }
        }
        
        TSP.GTS1(n,v,c);
        scanner.close();
    }
}
