package CreationalDP.SingletonDP;

public class SingletonObject {

    public String message="Merhaba";

    private static SingletonObject instance;

    private SingletonObject() {}

    public static SingletonObject getInstance(){
        if (instance==null){ //metod ilk kez çağrıldığında yeni bir obje üretilir, sonrasında ise aynı obje döndürülür.
            instance=new SingletonObject();
        }
        return instance;
    }


    public void changeMessage(){
        this.message+=" Design Pattern:)";
    }


}
