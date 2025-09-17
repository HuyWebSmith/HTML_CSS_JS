package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrList {

    private static Scanner sc;
    public static void main(String[] args){
        ArrayList<Integer> arrl1 = new ArrayList<>();

        ArrayList<Integer> arrl2 = new ArrayList<>(5);

        ArrayList<Integer> arrl3 = new ArrayList<>(List.of(1,2,3,4,5));

        System.out.println(arrl1);
        System.out.println(arrl2);
        System.out.println(arrl3);

        // add 1 phan tu co vu tri index
        arrl3.add(1, 6);
        System.out.println("After adding : " + arrl3);

        // so luong phan tu cua list
        System.out.println("Size of List at now : " + arrl3.size() + " elements");

        // return gia tri tai vi tri index
        System.out.println(" Value of the index 1 is " + arrl3.get(1));

        // xoa theo index chi dinh
        arrl3.remove(1);
        System.out.println("After delete index 1: " + arrl3);

        // Xoa gia tri trong list
        arrl3.remove(Integer.valueOf(3));
        System.out.println("After delete 3 in List: " + arrl3);
        

        //Thay doi phan tu trong index
        arrl3.set(0, 9);
        System.out.println("After changing : " + arrl3);

        // kiem tra xem co chua gia tri do trong list kh
        boolean check = arrl3.contains(9);
        boolean check1 = arrl3.contains(8);
        System.out.println("Checking : " + check);
        System.out.println("Checking 1 : " + check1);

        //sort tang dan

        ArrayList<Integer> arrl4 = new ArrayList<>(List.of(11,42,32,41,25,36,75,83,19,10));
        Collections.sort(arrl4);
        Collections.reverse(arrl4);
        System.out.println("After sorting : " + arrl4);

        Random rd = new Random();
        sc = new Scanner(System.in);
        System.out.println("Enter size of List: ");
        int n = sc.nextInt();
        ArrayList<Integer> arrl5 = new ArrayList<>();
        for(int i=0 ;i < n; i++){
            int random = rd.nextInt(1, 101);
            arrl5.add(random);

        }
        System.out.println(arrl5);

        ArrayList<Integer> arrl6 = new ArrayList<>();
        for(int x : arrl5){
            arrl6.add(x*x);
        }
        System.out.println(arrl6);
    }
}
