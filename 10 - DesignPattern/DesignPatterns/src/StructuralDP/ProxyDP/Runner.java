package StructuralDP.ProxyDP;

public class Runner {
    public static void main(String[] args) {


        RealClass realObject=new RealClass("C:\\image1.jpeg");//resim yüklendi.
        System.out.println(realObject.name);
        realObject.changeFormat();


        System.out.println("------------------ Proxy ---------------------------------");

        //otherMethod(ImageGenerator object);
        //bu metoda doğrudan realObject verirsek henüz objenin kendisine ihtiyacımız olmadığı
        //halde gereksiz yere zaman, performans, bellek vs kullanmış oluruz. Image yüklenmiş olur.
        //bunun yerine proxyObj kullanarak imageın yüklenmesini/gerçek objenin üretilmesi
        // geciktirerek performansı artırabiliriz

        ProxyClass proxyObject=new ProxyClass("C:\\image1.jpeg");//resim yüklenmedi, orjinal obje değil
        //proxyObject.name?-->gerçek obje henüz oluşturulmadı

        //başka işlemler....

        proxyObject.showImage();//gerçek objenin metodu çağrıldığında artık real object oluştu.
        //proxyObject.changeFormat-->diğer metodlara erişim yok, yani orjinal objenin yönetimini sağlamış olduk.



    }
}
