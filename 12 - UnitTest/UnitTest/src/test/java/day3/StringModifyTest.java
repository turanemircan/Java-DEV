package day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringModifyTest {

    StringModify object=new StringModify();

    @ParameterizedTest
    @CsvSource(value = {"BC,ABC","B,AB","BABCD,ABABCD","'',AA","BCD,BACD"})
    void deleteIfAIsInTwoPositionTest(String expected, String param){

        assertEquals(expected,object.deleteIfAIsInTwoPosition(param));

    }



}
