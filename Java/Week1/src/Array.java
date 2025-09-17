/* Nguyen Huy 2280601196 */
//Bai 6
package Week1.src;
import java.util.Scanner;
public class Array {
    private int Array[];
    private int integerArray;
    private int numberArray;

    public int[] getArray() {
        return Array;
    }

    public int getIntegerArray() {
        return integerArray;
    }

    public int getNumberArray() {
        return numberArray;
    }
        
    public void setArray(int[] array) {
        Array = array;
    }

    public void setIntegerArray(int integerArray) {
        this.integerArray = integerArray;
    }

    public void setNumberArray(int numberArray) {
        this.numberArray = numberArray;
    }
    

    public void Input(int[] Array,Scanner sc){
        for(int i=0;i< Array.length;i++){
            System.out.printf("Array[" + i + "]= ");
            Array[i] = sc.nextInt();
        }
    }

    public void Output(int[] Array,int numberArray){
        for(int i=0;i<numberArray;i++){
            System.out.printf(Array[i] + " ");
        }
    }

    public float averageOdd(int[] Array,int numberArray){
        int sum=0,count=0;
        for(int i= 0 ;i<numberArray;i++){
            if(Array[i] % 2 != 0){
                sum+= Array[i];
                count++;
            }
        }
            return (float)sum/count;
    }

    public int maxArray(int[] Array,int numberArray){
        int max = Array[0];
        for(int i= 0 ;i<numberArray;i++){
            if(Array[i] > max){
                max= Array[i];
            }
        }
            return max;
    }


    public void sort(int[] Array,int numberArray) {
        boolean swapped;
        for (int i = 0; i < numberArray - 1; i++) {
            swapped = false;
            for (int j = 0; j < numberArray - 1 - i; j++) {
                if (Array[j] < Array[j + 1]) {
                    int temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        Output(Array,numberArray);
    }
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Array: ");
        int numberArray = sc.nextInt();
        int[] Array = new int[numberArray] ;
        Input(Array, sc);
        System.out.print("Array: ");
        Output(Array, numberArray);
        System.out.printf("\n");

        float kq = averageOdd(Array, numberArray);
        System.out.println("Average of Odd= " + kq);

        int ln = maxArray(Array, numberArray);
        System.out.println("Element Max: " + ln);

        sort(Array, numberArray);
    }

    
}

class Demo2{
    public static void main(String[] args){
        Array arr = new Array();
        arr.Input(null, null);
        arr.Output(null, 0);
        arr.averageOdd(null, 0);
        arr.maxArray(null, 0);
        arr.sort(null, 0);
    }
}
