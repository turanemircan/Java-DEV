package day2;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test06_GroupingTest {

    //birbiri ile ilişkili olan testlerimizi gruplayabiliriz

    @Nested
    class MultiplyTest{

        @ParameterizedTest
        @CsvSource(value ={"-12,-3,4","-12,3,-4","12,-3,-4"})
        void testMultiplyWithNonZero(int result,int sayi1,int sayi2){
            assertEquals(result,Math.multiplyExact(sayi1,sayi2));
        }

        @ParameterizedTest
        @CsvSource(value ={"0,3,0","0,0,0","0,0,9"})
        void testMultiplyWithZero(int result,int sayi1,int sayi2){
            assertEquals(result,Math.multiplyExact(sayi1,sayi2));
        }

    }


    @Nested
    class AddTest{

        @ParameterizedTest
        @CsvSource(value ={"15,7,8","-5,-13,8","-9,-6,-3"} )
        void testAddWithNonZero(int result,int sayi1,int sayi2){
            assertEquals(result,Math.addExact(sayi1,sayi2));
        }

        @ParameterizedTest
        @CsvSource(value ={"7,7,0","8,0,8","-6,-6,0"} )
        void testAddWithZero(int result,int sayi1,int sayi2){
            assertEquals(result,Math.addExact(sayi1,sayi2));
        }

    }

}
