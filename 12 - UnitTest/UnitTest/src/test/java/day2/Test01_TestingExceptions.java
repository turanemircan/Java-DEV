package day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test01_TestingExceptions {

    //bazen metodlarımızın hatalı durumlarda exception fırlatmasını isteriz

    @Test
    void testException(){

        String str=null;

        //str.length();//NullPointerException

        assertThrows(NullPointerException.class,()->{
            str.length();
        });

    }

    @Test
    void testException2(){

        int sayi1=6;
        int sayi2=0;

       // System.out.println(sayi1 / sayi2);//ArithmeticException

        assertThrows(ArithmeticException.class,()->{
            System.out.println(sayi1 / sayi2);
        });

    }

    private int divide(int x,int y){
        //1 bölme işlemi : 6/3=2
        //2 ArithmeticExcp. fırlatmalı (6/0)
        //3 6/3 !=4
        return x/y;
    }

    @Test
    void testException3(){

        int sayi1=6;
        int sayi2=0;

        assertEquals(2,divide(6,3));

        assertThrows(ArithmeticException.class,()->{
            divide(sayi1,sayi2);
        });

    }




}
