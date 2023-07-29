package threads;
/*
Ölümcül Kilitlenme, iki veya daha fazla threadin çalışmak için
aynı kaynağa erişmek istemeleriyle oluşur.
Kaynağa erişmek için sürekli birbirlerini beklemesi sonucunda
sistem kaynakları olumsuz etkilenir ve uygulamanız(sunucu) cevap veremez hale gelebilir.
 */
public class DeadLock {
    public static void main(String[] args) {

        String seker="şeker";
        String kahve="kahve";

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (seker){
                    System.out.println(Thread.currentThread().getName()+" "+seker+" i kullanıyor.");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+kahve+" i istiyor.");
                    synchronized (kahve){
                        System.out.println(Thread.currentThread().getName()+" "+kahve+" i kullanıyor.");
                    }//kahve bırakıldı
                }//şeker bırakıldı
                System.out.println(Thread.currentThread().getName()+" sıcak su ekledi ve kahvesini yudumluyor.");
            }
        },"Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (kahve) {
                    System.out.println(Thread.currentThread().getName() + " " + kahve + " yi kullanıyor.");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+seker+" i istiyor.");
                    synchronized (seker){
                        System.out.println(Thread.currentThread().getName()+" "+seker+" i de ekledi");
                    }//şekeri bıraktı
                }//kahveyi de bıraktı
                System.out.println(Thread.currentThread().getName()+" sıcak su ekledi ve keyifle kahvesini içiyor.");

            }
        },"Jerry");
        thread2.start();


    }
}
