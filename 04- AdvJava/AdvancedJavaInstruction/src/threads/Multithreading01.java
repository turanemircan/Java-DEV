package threads;

public class Multithreading01 {
    public static void main(String[] args) {
        //TASK:1 den 10 a kadar sayıları ekrana 2 defa yazdırma
//        long start=System.currentTimeMillis();
//        Counter counter1=new Counter("Abdullah");
//        counter1.countMe();
//        Counter counter2=new Counter("Halil");
//        counter2.countMe();
//        long finish=System.currentTimeMillis();
//
//        System.out.println("Thread kullanmadan geçen süre: "+(finish-start));//10225


        System.out.println("---------------------MultiThreading------------------------------");

        long startTime=System.currentTimeMillis();
        CounterWithMultiThread counter3=new CounterWithMultiThread("Süleyman");
        CounterWithMultiThread counter4=new CounterWithMultiThread("Hasan");
        counter3.start();
        counter4.start();

/*        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    counter3.join();//counter3 işini bitirene kadar thread1 bekler.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("bazı işlemler");
            }
        });
        thread1.start();*/

        try {
            counter3.join();//hangi thread(main) içinde çağrılmışsa bu threadi counter3 threadi işini bitirene kadar bekler
            counter4.join();//hangi thread(main) içinde çağrılmışsa bu threadi counter4 threadi işini bitirene kadar bekler
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finishTime=System.currentTimeMillis();

        System.out.println("MultiThreading ile geçen süre: "+(finishTime-startTime));//5138






    }
}
class Counter{

    private String name;

    //param const
    public Counter(String name) {
        this.name = name;
    }

    //thread kullanmadan 1..10 kadar yazdırma
    public void countMe(){
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//main thread 0.5 sn uyusun
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+" - "+name);
        }
    }

}
class CounterWithMultiThread extends Thread{

    private String name;

    public CounterWithMultiThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        countMe();
    }

    public void countMe(){
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//main thread 0.5 sn uyusun
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+" - "+name);
        }
    }
}