package day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Test02_Assertions2 {

    //List -->contains

    @Test
    public void testListContains(){

        List<Integer> list= Arrays.asList(1,2,3,4);

       // assertEquals(true,list.contains(2));

        assertTrue(list.contains(2));
        assertFalse(list.contains(5));
    }

    //String--> split
    @Test
    public void testSplit(){
        String str="Infinity is bigger than you think!";
        String[] anlikDizi=str.split(" "); //{Infinity,is,bigger,than,you,think!}
        String[] beklenenDizi={"Infinity","is","bigger","than","you","think!"};

        assertTrue(Arrays.equals(beklenenDizi,anlikDizi));
    }





}
