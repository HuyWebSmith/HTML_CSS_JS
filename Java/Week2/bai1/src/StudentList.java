package Week2.bai1.src;
import java.util.Scanner;
public class StudentList{

    private Student[] Array;
    private int n;

    public Student[] getArray() {
        return Array;
    }

    public void setArray(Student[] array) {
        Array = array;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public StudentList(Student[] array, int n) {
        Array = array;
        this.n = n;
    }

    public StudentList(StudentList obj) {
        Array = obj.Array;
        this.n = obj.n;
    }

    public void InputStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Student: ");
        n= sc.nextInt();

        Array = new Student[n];
        for(int i=0;i<n;i++){
            Array[i] = new Student();
            Array[i].Input(); 
        }
    }

    public void OutputStudent(){
        for(int i=0;i<n;i++){
            Array[i].Output(); 
        }
    }
}