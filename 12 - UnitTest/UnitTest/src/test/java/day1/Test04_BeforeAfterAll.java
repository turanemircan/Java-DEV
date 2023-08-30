package day1;

import org.junit.jupiter.api.*;

public class Test04_BeforeAfterAll {

    @BeforeAll//before ve after all metodları static olmak zorundadır.
    static void openFile(){

        System.out.println("open a file");

    }

    @AfterAll
    static void closeFile(){

        System.out.println("close file");

    }


    @Test
    void testSplitWithArrays(TestInfo info){

        String str="Junit ile çalışmak harika";
        String[] anlikDizi=str.split(" ");
        String[] bekleneDizi={"Junit", "ile", "çalışmak", "harika"};

        System.out.println(info.getDisplayName()+" çalıştı.");

        Assertions.assertArrayEquals(bekleneDizi,anlikDizi);

    }

    @Test
    void testSplitWithArrays2(TestInfo info){

        String str="Junit ile çalışmak harika";
        String[] anlikDizi=str.split(" ");
        String[] bekleneDizi={"Junit", "ile", "çalışmak", "harika"};

        System.out.println(info.getDisplayName()+" çalıştı.");

        Assertions.assertArrayEquals(bekleneDizi,anlikDizi);

    }



}
