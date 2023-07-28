package threads;
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//wait-notify: threadler arasında iletişimi sağlar
public class WaitNotify {

    public static int balance=2000;

    public static void main(String[] args) {

        WaitNotify obj=new WaitNotify();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("öğrenci");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("veli");
        thread2.start();



    }

    //para çekme
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");
        if(balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz, mevcut bakiye: "+balance);
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();//thread1 bekleyecek:thread2 nin işini yapmasını. notify çağrılana kadar
                //thread1 geçici olarak objenin monitörünü serbest bırakır
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
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
        notify();//wait ile bekleyen threadi uyandırır, harekete geçirir.
        //notifyAll(); -->bekleyen tüm waitleri uyarır
    }
}
