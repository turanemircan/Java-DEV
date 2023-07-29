package practice.multiThreads.creation;

//Task:Runnable interfacini implement eden Counter isminde sınıf oluşturup
//bu sınıftan harfleri a dan z ye kadar yazdıran iki tane thread oluşturun

//Task: Başlarken Yarış başladı
//Bitince de yarış bitti desin
public class ThreadCreation2 {
    public static void main(String[] args) {
        System.out.println("Yarış Başladı");
        Counter c1=new Counter("Road Runner");
        Counter c2=new Counter("Speedy Gonzales");

        Thread thread1=new Thread(c1);
        Thread thread2=new Thread(c2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Yarış bitti");
    }
}
