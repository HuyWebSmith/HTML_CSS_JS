/* Nguyen Quang  Huy 2280601196 */
//Bai 10
package Week1.src;

import java.util.Scanner;
public class Fraction{
    private int numerator;
    private int denominator;
    
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int greatestCommonDivisor(int a, int b){
        a= Math.abs(a);
        b= Math.abs(b);
        while(b>0){
            int gcd = a%b;
            a=b;
            b=gcd;
        }
        return a;
    }


    public boolean checkIrreducible(){
        if(greatestCommonDivisor(numerator, denominator)==1){
            return true;
        }
        return false;
    }
    public void irreducible(){
        if(numerator == 0)
            return;
        if(denominator == 1)
            return;
        int x = greatestCommonDivisor(numerator, denominator);
        if(x == 1)
            return;
        numerator /= x;
        denominator /= x;
    }

    public void changeDenominator(){
        if(denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public void setNumerator(int numerator) {
        this.denominator = (denominator != 0 ) ? denominator: 1;
        irreducible();
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        irreducible();
        changeDenominator();
    }

    public Fraction(int numerator, int denominator){
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public Fraction(){
        this(1,1);
    }

    public Fraction(int n){
        numerator = n;
        denominator = 1;
    }

    public Fraction(Fraction p){
        numerator = p.numerator;
        denominator = p.denominator;
    }


    public void Input(Scanner sc){
        System.out.printf("Enter numerator : ");
        numerator = sc.nextInt();
        System.out.printf("Enter denominator : ");
        denominator = sc.nextInt();
    }
    public void Output(){
        if (numerator == 0) 
            System.out.print("[0]");
        else if (denominator == 1)
            System.out.print(numerator);
        else 
            System.out.print( numerator +"/" + denominator );
    }

    public Fraction sumFraction(Fraction f){
        Fraction kq =new Fraction();
        kq.numerator = numerator * f.denominator + denominator * f.numerator;
        kq.denominator = denominator * f.denominator;
        kq.irreducible();;
        return kq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();
        
        System.out.println("Enter Fraction 1 ");
        fraction1.Input(sc);
        System.out.println("===============================");
        System.out.println("Enter Fraction 2 ");
        fraction2.Input(sc);

        fraction1.irreducible();
        fraction2.irreducible();
        System.out.println("===============================");
        System.out.printf("Fraction1: ");
        fraction1.Output();
        System.out.printf("\n");
        System.out.printf("Fraction2: ");
        fraction2.Output();
        System.out.printf("\n");
        
        System.out.println("===============================");
        Fraction fraction3 = fraction1.sumFraction(fraction2);
        System.out.println("Sum");
        fraction1.Output();
        System.out.print(" + ");
        fraction2.Output();;
        System.out.print(" = ");
        fraction3.Output();
        System.out.println();
        sc.close();
    }

    
}