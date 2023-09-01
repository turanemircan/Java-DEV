package day3.mocking;

import day3.mocking.sample2.ProductManager;
import day3.mocking.sample2.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ShoppingCartServiceTest {


    @Test
    void addProductToCartTest(){

        ProductManager productManager=mock(ProductManager.class);
        when(productManager.getStockStatus("ABC123")).thenReturn(5);
       // when(productManager.getStockStatus("ABC124")).thenReturn(0);



        ShoppingCartService cartService=new ShoppingCartService(productManager);
        boolean result=cartService.addProductToCart("ABC123");//expected:true

        assertTrue(result);
//        verify(productManager).decreaseStock("ABC123");
//        verify(productManager).getStockStatus("ABC123");

        InOrder inOrder=inOrder(productManager);
        inOrder.verify(productManager).getStockStatus("ABC123");
        inOrder.verify(productManager).decreaseStock("ABC123");

    }

    @Test
    void addProductToCartTestForNotEnoughStock(){

        ProductManager productManager=mock(ProductManager.class);
        when(productManager.getStockStatus("ABC124")).thenReturn(0);



        ShoppingCartService cartService=new ShoppingCartService(productManager);
        boolean result=cartService.addProductToCart("ABC124");//expected:false

        assertFalse(result);
        verify(productManager).getStockStatus("ABC124");



    }



}
