package threads;
//aynı anda erişilen ortak metodda sırası önemli olmayan kodlar da varsa
public class SynchronizedBlock {
    public static void main(String[] args) {

        Brackets2 brackets=new Brackets2();

        long start=System.currentTimeMillis();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets.generateBrackets();
                }
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=1;i<=9;i++){
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish=System.currentTimeMillis();


        //System.out.println("Metod synchronized iken Geçen süre:"+(finish-start));//5603
        System.out.println("Blok synchronized iken Geçen süre:"+(finish-start));//2819

    }


}
class Brackets2{
    public /*synchronized*/ void generateBrackets(){
    //bu bloğa aynı anda sadece 1 thread erişebilir
      synchronized (this){
            for (int i=1;i<=10;i++){
                if(i<=5){
                    System.out.print("[ ");
                }else {
                    System.out.print("] ");
                }
            }
            System.out.println(" - "+Thread.currentThread().getName());
      }



        //senkron olması gerekmeyen başka kodlar da varsa
        for (int i=0; i<5;i++){

            System.out.println(i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
