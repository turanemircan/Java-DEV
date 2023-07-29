package practice.multiThreads.volatileKeyword;

public class Numarator {

    private volatile static int counter=0;
    //volatile ile counter sayısı ram e akyıt olur
    //ancak tüm threadler değişkene aynı anda ulşamasından kaynaklı sorunu çözmez
    //bu sorunu çözmek için synchronized keywordu kullanılır

    public synchronized void getOrder(){
        String name=Thread.currentThread().getName();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter++;
        System.out.println("Sayın "+name+ " sıranız : "+counter);
    }
}
