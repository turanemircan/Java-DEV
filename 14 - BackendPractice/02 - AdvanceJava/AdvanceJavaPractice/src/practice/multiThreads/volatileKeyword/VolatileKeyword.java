package practice.multiThreads.volatileKeyword;
/*
Birden fazla thread kullanılan bir uygulamada, değişkenler performans nedeniyle CPU cache'inde tutulabilir.
Bilgisayarın birden fazla CPU'su(çekirdek) olduğunu düşünürsek her thread farklı CPU üzerinde çalışabilir.
Bu nedenle her thread değişkenlerin değerini CPU cache'ine farklı değerde yazabilir.
'volatile' keywordü değişken üzerinde bir değişiklik olduğunda diğer threadler tarafından görünmesini garanti eder.
'volatile' bir değişken CPU cache yerine bilgisayarın main memory'sinden okunur ve CPU cache yerine main memory'sine yazılır.
non-volatile değişkenler için böyle bir garanti yoktur.

 Task:Banka/Hastahane işlemleri için sıra numarası veren bir uygulama (Numarator) tasarlayınız.
 Uygulama her talep için bir sonraki sırayı vermeli
 */
public class VolatileKeyword {
    public static void main(String[] args) {
        Numarator numarator=new Numarator();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                numarator.getOrder();
            }
        });
        thread1.setName("Shan");
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                numarator.getOrder();
            }
        });
        thread2.setName("Han");
        thread2.start();
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                numarator.getOrder();
            }
        });
        thread3.setName("Kinomia Takao");
        thread3.start();
    }
}
