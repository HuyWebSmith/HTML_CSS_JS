package SchoolManagement.Student;

import java.util.Scanner;

public class Student extends School{
    private String studentID;
    private float mathsPoint; 
    private float physicsPoint;
    private float chemistryPoint;

    private static Scanner sc;
    public Student(){
        super();
        this.studentID= null;
        this.mathsPoint = 0;
        this.chemistryPoint = 0;
        this.physicsPoint = 0;
    }

    public Student(
        String name, 
        int age, 
        int gender,
        String studentID, 
        float mathsPoint,
        float chemistryPoint,
        float physicsPoint
        ) {
        super(name,age,gender);
        this.studentID= studentID;
        this.mathsPoint = mathsPoint;
        this.chemistryPoint = chemistryPoint;
        this.physicsPoint = physicsPoint;
    }

    public Student(Student obj){
        super(obj);
        this.studentID= obj.studentID;
        this.mathsPoint = obj.mathsPoint;
        this.chemistryPoint = obj.chemistryPoint;
        this.physicsPoint = obj.physicsPoint;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getMathsPoint() {
        return mathsPoint;
    }

    public void setMathsPoint(float mathsPoint) {
        this.mathsPoint = mathsPoint;
    }

    public double getPhysicsPoint() {
        return physicsPoint;
    }

    public void setPhysicsPoint(float physicsPoint) {
        this.physicsPoint = physicsPoint;
    }

    public double getChemistryPoint() {
        return chemistryPoint;
    }

    public void setChemistryPoint(float chemistryPoint) {
        this.chemistryPoint = chemistryPoint;
    }

    @Override 
    public void inputInformation(){
        sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        studentID = sc.nextLine();
        super.inputInformation();
        System.out.print("Enter Maths Point: ");
        mathsPoint = sc.nextFloat();
        System.out.print("Enter Physics Point: ");
        physicsPoint = sc.nextFloat();
        System.out.print("Enter Chemistry Point: ");
        chemistryPoint = sc.nextFloat();
    }

    @Override
    public String toString(){
        
        return String.format("| %-8s |" + super.toString() + "| %-6.2f | %-6.2f | %-6.2f | %-6.2f |", 
        studentID,
        mathsPoint,
        physicsPoint,
        chemistryPoint,
        sum(mathsPoint, physicsPoint, chemistryPoint)
        );
    }

    public float sum(float mathsPoint,float physicsPoint,float chemistryPoint){
        return ((mathsPoint * 2) + (chemistryPoint *2) + physicsPoint) / 5;
    }
}
