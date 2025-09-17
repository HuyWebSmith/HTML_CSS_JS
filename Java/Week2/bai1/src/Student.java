package Week2.bai1.src;
import java.util.Scanner;
public class Student{
    private String studentID;
    private String name;
    private double point;

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getPoint() {
        return point;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(double point) {
        this.point = point;
    }


    public void Input(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        studentID = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Point: ");
        point = sc.nextDouble();
    }

    public void Output(){
        System.out.print(studentID + "\t" + name + "\t" + point );
    }
}