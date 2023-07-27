package threads;

public class Multithreading02 {

    public static int counter=0;

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("bazı kodlar");
                Counter01.count();
                System.out.println("bazı kodlar");
                //ortak kaynağı kullanmayan başka görevler
            }
        });
        thread1.setName("Tom");
        thread1.start();

        //joın olmaz çözüm
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("farklı kodlar");
                Counter01.count();
                System.out.println("farklı kodlar");
                //başka görevler
            }
        });
        thread2.setName("Jerry");
        thread2.start();




    }
}
class Counter01{

    //synchronized  ile threadlerin metoda erişmesini sıraya koymuş olduk
    //metod içine sadece 1 thread girebilsin
    public synchronized static void count(){

        for (int i=1;i<=1000;i++){
            Multithreading02.counter++;//1000
            System.out.println(Thread.currentThread().getName()+" ---> counter :"+Multithreading02.counter);
        }

    }
}

