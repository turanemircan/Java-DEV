package CreationalDP.PrototypeDP;

public class Runner {
    public static void main(String[] args) {

        Soldier soldierAvailable=new Soldier(100,20,60,"Kılıç",true);//80 asker
        Soldier soldierNotAvailable=new Soldier(100,20,60,"Kılıç",false);
        Soldier soldierWeapon=new Soldier(100,20,60,"OK",true);

        //bir tane askeri prototip olarak alsak ve klonlasak, sadece farklı olan özelliklerini set etsek
        //soldierAvailable objemiz prototip olsun.

        Soldier soldier4=soldierAvailable.clone();


        System.out.println("------------prototip-------------------");
        soldierAvailable.printInfo();
        System.out.println("------------clone soldier-------------------");
        soldier4.printInfo();
        System.out.println("------------clone soldierNotAvailable-------------------");
        Soldier soldier5=soldierAvailable.clone();
        soldier5.setAvailable(false);
        soldier5.printInfo();








    }
}
