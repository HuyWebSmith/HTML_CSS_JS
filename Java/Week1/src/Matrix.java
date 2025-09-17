/*Nguyen  Huy 2280601196 */
//Bai 9
package Week1.src;
import java.util.Scanner;
import java.util.Random;
public class Matrix {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int row,cols;
        System.out.printf("Enter row: ");
        row = sc.nextInt();
        System.out.printf("Enter columns: ");
        cols = sc.nextInt();

        int[][] matrix = new int[row][cols] ; 
        for(int i = 0;i< row;i++){
            for(int j = 0;j< cols;j++){
                matrix[i][j] =rd.nextInt((100-1)+1)+ 1;
                System.out.printf(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        int k,s;
        System.out.printf("Enter k: ");
        k = sc.nextInt();
        s=sum(matrix, cols, k);
        System.out.printf("Sum: " + s);

        sc.close();
    }
    public int sum(int matrix[][],int cols,int k){
        int sum = 0;
        for(int j = 0;j<cols;j++){
            sum += matrix[k][j];
        }
        return sum;
    }
}
