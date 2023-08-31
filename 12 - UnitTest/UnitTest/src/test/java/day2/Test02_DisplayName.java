package day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test02_DisplayName {

    //@DisplayName: test penceresinde veya testInfoda yazdığımız açıklama cümlesini görmemizi sağlar

    @Test
    @DisplayName("Test parseInt() to check does throw NumberFormatException when non digit value is given")
    void testParseIntWhenNondigitValue(TestInfo info){//test_parseInt_check_does_throw_NumberFormatException_when_nondigit_value

        String str="Merhaba";//"123";
        String str2="123";//"123";

        //Integer.parseInt(str);//return 123

        System.out.println(info.getDisplayName());

        assertThrows(NumberFormatException.class,()->{
            Integer.parseInt(str);
        },"NumberFormatException fırlatılmadı.");

    }



}
