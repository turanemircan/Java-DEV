package day1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//testlerin çalışma sırasını kendimiz belirlemek istersek @TestMethodOrder anno
//class seviyesinde kullanılır.


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test03_BeforeAfterEach {


    //bu classta test edeceğimiz tüm metodlarda String objesine ihtiyacımız.
    String str;

    @BeforeEach//aşağıdaki metodu her bir testten önce çalıştırır
    void beforeEach(){
        str="Junit ile çalışmak harika";
        System.out.println("--------------beforeEach çalıştı.");
    }

    @AfterEach//aşağıdaki metodu her bir testten sonra çalıştırır
    void afterEach(){
        str=null;
        System.out.println("--------------afterEach çalıştı.");

    }

    @Test
    @Order(2)
    void testSplit(TestInfo info){
        //String str="";

        String[] anlikDizi=str.split(" ");
        String[] bekleneDizi= {"Junit","ile", "çalışmak", "harika"};

        System.out.println(info.getDisplayName()+" çalıştı");

       assertArrayEquals(bekleneDizi,anlikDizi);

    }

    @Test
    @Order(1)
    void testLength(TestInfo info){

        //String str="";

        System.out.println(info.getDisplayName()+" çalıştı");

        assertEquals(25,str.length());

    }














}
