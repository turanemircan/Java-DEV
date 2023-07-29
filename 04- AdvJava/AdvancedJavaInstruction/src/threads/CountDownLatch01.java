package threads;

import java.util.concurrent.CountDownLatch;

/*
bazı threadlerin önce çalışmasını
bu arada diğer threadlerin ve main threadin de beklmesini istediğimiz
durumlarda CountDownLatch ile bir sayaç oluşturulur ve
öncelik verdiğimiz her bir thread işini tamaladığında sayaç 1 azaltılır
sayaç 0 olduğunda diğer threadlerin ve main threadin çalışmaya devam etmesine izin verilir.
 */
public class CountDownLatch01 {
    public static void main(String[] args) {

        System.out.println("main thread başladı");

        CountDownLatch latch=new CountDownLatch(4);

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+" threadi çalışmaya başladı.");

                try {
                    latch.await();//countdown metodu ile sayaç=0 olana kadar bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" threadi çalışmaya devam ediyor.");
            }
        },"Car");//new Thread(Runnable target, String name)
        thread1.start();

        WorkerThreads worker1=new WorkerThreads("worker1",6000,latch);
        WorkerThreads worker2=new WorkerThreads("worker2",5000,latch);
        WorkerThreads worker3=new WorkerThreads("worker3",3000,latch);
        WorkerThreads worker4=new WorkerThreads("worker4",7000,latch);
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        try {
            latch.await();//worker threadleri bekle
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main thread çalışıyor...");



    }
}

class WorkerThreads extends Thread{

    private int duration;//bekleme süresini dinamik olarak belirlemek için

    private CountDownLatch latch;


    public WorkerThreads(String name,int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName()+" çalışmaya başladı.");
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName()+" işini bitirdi.");
            latch.countDown();//3-2-1-->0 olduğunda diğer threadlere izin ver
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
