package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService service =Executors.newFixedThreadPool(3);

        ThreadCreator thread1=new ThreadCreator("A",7000);
        ThreadCreator thread2=new ThreadCreator("B",3000);
        ThreadCreator thread3=new ThreadCreator("C",2000);
        ThreadCreator thread4=new ThreadCreator("D",1000);
        ThreadCreator thread5=new ThreadCreator("E",5000);
        ThreadCreator thread6=new ThreadCreator("F",9000);
        ThreadCreator thread7=new ThreadCreator("G",500);

//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();


        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);
        service.execute(thread7);

        service.shutdown();//havuzu sonlandırır, aksi halde threadler havuzda beklemeye devam eder.




    }
}
class ThreadCreator extends Thread{

    private String task;

    private int duration;//sleep süresini dinamik olarak belirlemek için

    public ThreadCreator(String task,int duration) {
        this.task = task;
        this.duration=duration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" başladı."+task+ " işini yapıyor.");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" bitirdi.");

    }
}

