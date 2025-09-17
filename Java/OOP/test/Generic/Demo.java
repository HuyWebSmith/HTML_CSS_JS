package test.Generic;
class Demo {
    public static void main(String[] args){
        Generics<Integer,Integer> printInteger = new Generics<>(7,11);
        System.out.println(printInteger.x + " " +  printInteger.y);

        Generics<Double,String> printDouble = new Generics<>(21.4,"Ngay sinh.");
        System.out.println(printDouble.x + " " + printDouble.y);

        Generics<String,Double> printString = new Generics<>("I'm Huy",13.5);
        System.out.println(printString.x + " " + printString.y);
    }
}

