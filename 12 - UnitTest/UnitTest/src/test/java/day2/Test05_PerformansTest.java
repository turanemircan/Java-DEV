package day2;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class Test05_PerformansTest {

    //task in çözümü için yazılan kodun maks. 2 sn içinde sonuç dönmesini
    // aksi halde durdurulmasını isteyebiliriz.

    @Test
    void testPrintPerformance(){
        //1-500000 olan sayıları yazdırma

        assertTimeout(Duration.ofSeconds(3),()->{
            IntStream.rangeClosed(1,500000).forEach(System.out::println);
        });

    }

    @Test
    void testPerformance(){

        assertTimeout(Duration.ofMillis(5),()->{

            IntStream.rangeClosed(1,50000).reduce((x,y)->Math.addExact(x,y));

        });
    }



}
