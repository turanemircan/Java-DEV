package threads;

import java.util.concurrent.Semaphore;

/*
Semaphore, ortak bir kaynağa sadece n tane threadin
aynı anda erişmesine izin vermemizi sağlar.

Synchronized, ortak kaynağa(metod/blok) aynı anda sadece
1 threadin erişmesine izin veriyordu.
 */
public class Semaphore01 {
    public static void main(String[] args) {

        Semaphore semaphore=new Semaphore(4);

        System.out.println("Toplam park yeri: "+semaphore.availablePermits());

        Car car1=new Car("Audi",3000,semaphore);
        Car car2=new Car("BMW",9000,semaphore);
        Car car3=new Car("Honda",5000,semaphore);
        Car car4=new Car("Anadol",2000,semaphore);
        Car car5=new Car("Ford",8000,semaphore);
        Car car6=new Car("Mazda",4000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();


    }
}

class Car extends Thread{

    private String carName;

    private int duration;

    private Semaphore semaphore;

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(carName+ " park etmek istiyor...");
            semaphore.acquire();//kodlara erişim için izin alındı
            //ortak kaynak başlangıç
            System.out.println("--->"+carName+ " park yerine girdi.");
            System.out.println(carName+ " park yerinde bekliyor.");
            Thread.sleep(duration);
            System.out.println("<---"+carName+ " park yerinden ayrılıyor..");
            //ortak kaynak bitiş
            semaphore.release(); //izin belgesi geri verildi.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
