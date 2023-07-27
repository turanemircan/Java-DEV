package practice.multiThreads.creation;
/*
1.Multithreading programlama nedir?
Aynı processtte birden fazla iş parçacığınınaynı anda çalışma süreci

2.Threadler ..2.şeklinde oluşturulur.

1. Thread sınıfından extend....eden alt sınıf oluşturulup, onun .run...methodu override edilir,
2..Runnable interface inden... implement edilerek, run override edilerek oluşturulur
ardından ..Thread...sınıfının constructorına nesne olarak gönderilir.

3.Run methodunu doğrudan Main methodundan çağırabilir miyiz?
evet ama thread başlatılmaz


4.Javada herhangi bir thread oluşturmazsak uygulamalar nerde nasıl çalışır?
Java varsayılan olarak tümuygulamalarda main threadini kullanır.


 */
public class ThreadCreation1 {

    //Task : Thread sınıfını extend eden Sayac isminde class oluşturup
    // bu classta sayıları 1 den 100 e kadar yazdıran günlük olaylardan iki tane thread örneği oluşturunuz
    public static void main(String[] args) {

        //threadleri olustur
        Sayac thread1=new Sayac("Domates");
        Sayac thread2=new Sayac("Salatalık");

        //threadleri calistir
        thread1.start();
        thread2.start();
    }
}
