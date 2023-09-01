package day3.mocking.sample2;

import java.util.Random;

public class ProductManager {

    public int getStockStatus(String productId){

        Random random=new Random();

        return random.nextInt(10);
    }


    public void decreaseStock(String productId){

        //bu metodun çalışıp/çalışmadığı service classındaki
        // metodu test ederken önemli olmadığı(göz ardı edildiği) için
        // özellikle bodyi boş bıraktık.

    }


}
