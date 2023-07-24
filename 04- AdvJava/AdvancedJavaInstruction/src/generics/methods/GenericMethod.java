package generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        Integer[] intArr={2,3,8,99,55};
        Double[] doubleArr={1.3,35.6,99.9,0.5};
        String[] stringArr={"Java","generics","hayatımızı","kolaylaştırır"};

        System.out.println("----------------generic olmayan bir metod-------------------");
        printArr(intArr);
        printArr(doubleArr);
        printArr(stringArr);

        System.out.println("----------------generic metod-------------------");
        printArray(intArr);
        printArray(doubleArr);
        printArray(stringArr);

        System.out.println("----------------sonuç döndüren generic metod-------------------");
        System.out.println(getFirst(intArr));
        getFirst(doubleArr);
        getFirst(stringArr);
        System.out.println("----------------iki parametreli generic metod-------------------");
        printArrayAndObject(intArr,"String");
        printArrayAndObject(intArr,12);




    }

    //arrayleri yazdırmak için bir metod
    public static void printArr(Integer[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
   //overloading
    public static void printArr(Double[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //overloading
    public static void printArr(String[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //generic metod
    public static <T> void printArray(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //geriye sonuç döndüren generic metod
    public static <T> T getFirst(T[] arr){

        T first=arr[0];
        return first;
    }

    //birden fazla parameterli generic metod
    public static <T,U> void printArrayAndObject(T[] array, U object){

      //  array[0]=object;//T ve U data tipleri farklı olabilir.

           Arrays.stream(array).forEach(t-> System.out.print(t+" "));
           System.out.print("----------------"+object);
        System.out.println();
    }








}
