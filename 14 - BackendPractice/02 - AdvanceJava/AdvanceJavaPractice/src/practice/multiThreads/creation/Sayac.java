package practice.multiThreads.creation;

public class Sayac extends Thread{


    private String name;

    public Sayac(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name+" ekim işlemi başladı");
       for(int i=1;i<=100;i++){
           System.out.println(this.name+" büyüyor ve boyu "+i+" cm oldu");

           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

       }
        System.out.println(this.name+" büyüdü yenmeye hazır");
    }
}
