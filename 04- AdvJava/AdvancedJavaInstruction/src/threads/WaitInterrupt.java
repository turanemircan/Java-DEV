package threads;
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//wait-notify: threadler arasında iletişimi sağlar
public class WaitInterrupt {

    public static int balance=0;

    public static void main(String[] args) {

        WaitInterrupt obj=new WaitInterrupt();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("tüketici");//consumer
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(200);
                thread1.interrupt();//thread1 in işini kesintiye uğratır.
            }
        });
        thread2.setName("üretici");//producer
        thread2.start();



    }

    //para çekme
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");
        if(balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz, mevcut bakiye: "+balance);
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();//interrupt metodu çağrıldığında bekleme kesilir ve InterruptedException fırlatılır
            } catch (InterruptedException e) {
                System.out.println("Bekleme işi kesildi");
                System.out.println("Bakiye yeniden kontrol ediliyor...");
            }
        }

        if (amount<=balance){
            balance=balance-amount;
            System.out.println("Para çekme işlemi başarıyla tamamlandı. Mevcut bakiye:"+balance);

        }else {
            System.out.println("Bakiye yetersiz, mevcut bakiye: "+balance);
            System.out.println("Bugün git, yarın gel...");
        }

    }

    //para yatırma
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor.");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi başarıyla gerçekleşti. Mevcut bakiye: "+balance);
    }
}
