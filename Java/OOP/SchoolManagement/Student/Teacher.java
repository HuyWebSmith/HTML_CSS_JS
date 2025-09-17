package SchoolManagement.Student;

import java.util.Scanner;

public class Teacher extends School{
    private String teacherID;
    private String classTeaching;

    private static Scanner sc;
    public Teacher(){
        super();
        this.teacherID = null;
        this.classTeaching = null;
    }

    public Teacher(String name , int age , int gender,String teacherID,String classTeaching){
        super(name,age,gender);
        this.teacherID = teacherID;
        this.classTeaching = classTeaching;
    }

    public Teacher(Teacher obj){
        super(obj);
        this.teacherID = obj.teacherID;
        this.classTeaching = obj.classTeaching;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getClassTeaching() {
        return classTeaching;
    }

    public void setClassTeaching(String classTeaching) {
        this.classTeaching = classTeaching;
    }

    @Override
    public void inputInformation(){
        sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        teacherID = sc.nextLine();
        super.inputInformation();
        System.out.print("Enter Class: ");
        classTeaching = sc.nextLine();
    }

    @Override
    public String toString(){
        return String.format("| %-8s |" + super.toString() + " | %-8s |", teacherID,classTeaching);
    }
}
