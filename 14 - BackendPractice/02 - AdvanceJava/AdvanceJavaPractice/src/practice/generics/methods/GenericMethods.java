package practice.generics.methods;

import java.util.Arrays;

public class GenericMethods {
    public static void main(String[] args) {
        String [] stdList={"Rafeel","Donatello","Leonardo","MichelAngelo"};
        Double [] pointList={75.5,80.0,90.75,78.5};
        Character []gradeList={'A','C','D','B'};
//1.Tüm listeleri yazdır
        printArray(stdList);
        printArray(pointList);
        printArray(gradeList);

//2.Öğrencileri isimlerine göre sıralayınız

        orderArray(stdList);

//3.Öğrenci notlarını sıralayınız
        orderArray(pointList);

//4.Öğrenci harf notlarını sıralayınız
        orderArray(gradeList);

    }

    //Diziyi yazdıran bir method yazınız
    public static <T> void printArray(T[] array){
        for(int i=0;i< array.length;i++){
            System.out.print(array[i]+"-");
        }
        System.out.println();
    }

// Diziyi artan sıralayan bir method yazınız
    public static <T> void orderArray(T[] array){
        Arrays.stream(array).sorted().forEach(t-> System.out.print(t+"-"));
        System.out.println();
    }
}
