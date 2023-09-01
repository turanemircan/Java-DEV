package day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTwoLastTwoTest {

    FirstTwoLastTwoChar obj=new FirstTwoLastTwoChar();

    @ParameterizedTest
    @CsvSource(value = {"true,BABA","false,ABBA","false,BCDCA","true,BCABC","false,B","true,AB","false,''"})
    void checkAreSameFirstTwoLastTwoTest(boolean expected, String param){

        assertEquals(expected,obj.checkAreSameFirstTwoLastTwo(param));


    }





}
