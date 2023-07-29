package practice.multiThreads.synchronization;
//Multithreading programlamada birden fazla Thread aynı anda ortak bir kaynağa erişmeye çalışırsa
//istenmeyen sonuçlar oluşacaktır. Bu durumda threadlere sırayla erişim vermek gerekecektir.
//Bir thread kaynağı kullanırken diğerleri onu beklemelidirler. Bu "synchronized" keywordu ile sağlanır.

/* Task: Bir randevu oluşturma uygulaması tasarlayınız.. (AppointmentCenter)
Uygulama herbir talep için bir gün sonrasını tarih vermelidir.
 */
public class AppointmentApp {
    public static void main(String[] args) {

        String [] users={"Bill","Steve","Linus","Tim","Larry"};
        AppointmentCenter appointmentCenter=new AppointmentCenter();

        for(String user :users) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName(user);
                    String name = Thread.currentThread().getName();
                    System.out.printf("Sayın %-8s, Randevu tarihiniz :%10s \n", name, appointmentCenter.getAppointmentDate());
                }
            });
            thread.start();
        }

    }
}
