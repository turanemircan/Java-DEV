package day3.mocking.sample2;

public class ShoppingCartService {

    private final ProductManager productManager;

    public ShoppingCartService(ProductManager productManager) {
        this.productManager = productManager;
    }

    //bu metod test edelim
    public boolean addProductToCart(String productId){

        int stock=productManager.getStockStatus(productId); //5/0

        if (stock>0){
            //ürün sepete eklendi.
            productManager.decreaseStock(productId);
            return true;
        }else {
           //ürün ekleme başarısız
           return false;
        }
    }


}
