package SchoolManagement.StudentList;

import java.util.Scanner;

import SchoolManagement.Student.*;

public class DemoS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(hs);
        
        SchoolList hsList = new SchoolList();
        
        
        
        boolean count = true;
        do {
            System.out.println("==============Menu===============");
            System.out.println("= 1. Enter Student Information  =");
            System.out.println("= 2. Enter Teacher Information  =");
            System.out.println("= 3. Print Student Information  =");
            System.out.println("= 4. Print Teacher Information  =");
            System.out.println("= 5. Logout                     =");
            System.out.println("=================================");
            System.out.print("Enter function: ");
            int choice = sc.nextInt();
            int type;
            switch(choice){
                case 1:
                School hs = new Student();
                hs.inputInformation();
                hsList.addList(hs);
                break;

                case 2:
                School gv = new Teacher();
                gv.inputInformation();
                hsList.addList(gv);
                break;

                case 3:
                type = 1;
                hsList.Output(type);
                break;

                case 4:
                type = 2;
                hsList.Output(type);
                break;

                case 5:
                System.exit(0);
                break;

                case 6:
                type = 1;
                hsList.sortName();
                hsList.Output(type);
                break;
            }
        } while (count);

        sc.close();
    }
}
