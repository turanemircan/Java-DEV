package day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test03_ParameterizedTest {


    @Test
    void testLength(){

        assertTrue("fevzi".length()>0);
        assertTrue("     ".length()>0);
        assertTrue("Umit".length()>0);
        assertTrue("FARUK".length()>0);

    }

    //yukarıdaki testte 4 defa asserTrue kullandık, bunun yerine bir kere assertTrue kullanarak
    //birden fazla parametreyi kullanarak nasıl test ederiz?

    @ParameterizedTest
    @ValueSource(strings = {"fevzi","   ","Umit","FARUK"})
    void testLength2(String str){

        assertTrue(str.length()>0);

    }

    @Test
    void testUpperCase(){

        String str1="Merhaba";
        String str2="javA";
        String str3="tEsT";

        assertEquals("MERHABA",str1.toUpperCase());
        assertEquals("JAVA",str2.toUpperCase());
        assertEquals("TEST",str3.toUpperCase());

    }
    @ParameterizedTest
    @CsvSource(value = {"Merhaba, MERHABA","javA,JAVA","tEsT, TEST"})
    void testUpperCase2(String str1,String str2){

        assertEquals(str2,str1.toUpperCase());

    }

    @ParameterizedTest
    @CsvSource(value = {"true,java,a","false,junit,k"})
    void testContains(boolean b,String str1,String str2){

        assertEquals(b,str1.contains(str2));

    }























}
