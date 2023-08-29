package CreationalDP.SingletonDP;

public class Runner {
    public static void main(String[] args) {

//        SingletonObject object1=new SingletonObject();
//        SingletonObject object2=new SingletonObject();
//        System.out.println(object1 == object2);
//        //referansları farklı

        SingletonObject object3=SingletonObject.getInstance();
        SingletonObject object4=SingletonObject.getInstance();
        System.out.println(object3 == object4);
        //referanslar artık aynı

        System.out.println("----------------Object3 ün mesajı--------------------------");

        System.out.println(object3.message);//Merhaba
        object3.changeMessage();
        System.out.println(object3.message);//Merhaba Design Pattern

        System.out.println("------------------Object4 ün mesajı-------------------------");
        System.out.println(object4.message);

        //SingletonObject object5=new SingletonObject();
        //default const private olmalı ki farklı referans ile obje oluşturulamasın.


    }
}
