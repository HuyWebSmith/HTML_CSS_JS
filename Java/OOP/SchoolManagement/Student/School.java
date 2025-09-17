package SchoolManagement.Student;

import java.util.Scanner;

public class School {
    private String name;
    private int age;
    private int gender;

    private static Scanner sc;

    public School(){
        this.name= null;
        this.age = 0;
        this.gender = 0;
    }

    public School(String name,int age, int gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public School(School obj){
        this.name = obj.name;
        this.age = obj.age;
        this.gender = obj.gender;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(int gender){
        if(gender ==1 && gender == 0) 
            this.gender = gender;
        else 
            System.out.println("Error!! [male: 0 , female: 1]");
    }
    
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGender(){
        return gender;
    }
    

    public void inputInformation(){
        sc = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        name = sc.nextLine();
        System.out.print("Enter Your Age: ");
        age = sc.nextInt();
        System.out.print("Enter Your Gender[male:0,female:1]: ");
        gender = sc.nextInt();
    }

    @Override
    public String toString(){
        return String.format(" %-10s | %-6d | %-6d ", name,age,gender);
    }

}
