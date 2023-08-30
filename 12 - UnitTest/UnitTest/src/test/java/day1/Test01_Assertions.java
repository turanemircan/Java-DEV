package day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Test01_Assertions {

    @Test//bir metodun test metodu old belirtir ve junit tarafından çalıştırılabilir hale gelir.
    public void test(){
        //test metodlarının erişimi public olmak zorunda(Junit4 ve öncesinde)
        //Junit5 ile birlikte public yazmak zorunda değiliz.
    }

    @Test
    public void testLength(){

       String str="Unit test çok kolay";
       int anlikDeger=str.length();//19
       int beklenenDeger=19;

       assertEquals(beklenenDeger,anlikDeger,"length metodu hatalı");
       //aldığı parametrelerin dğerlerini karşılaştırır
       //eğer değerler aynı ise test geçer, aksi halde kalır.
        //testin başarısız olması durumunda mesaj yazılabilir.

    }

    //String-->toUpperCase
    @Test
    public void testUpperCase(){

        String str="junıt";
        String beklenen="JUNI";
        String beklenmeyen="Junıt";
        String anlik=str.toUpperCase();

       assertEquals(beklenen,anlik);
       // assertNotEquals(beklenmeyen,anlik);

    }

    //Math.addExact
    @Test
    public void testAddExact(){
        int sayi1=15;
        int sayi2=5;

        int anlikDeger=Math.addExact(sayi1,sayi2);
        int beklenenDeger=sayi1+sayi2;

        assertEquals(beklenenDeger,anlikDeger);

    }

    //String-->contains
    @Test
    public void testContains(){

        assertEquals(false,"JAVA".contains("z"));

    }







}
