package StructuralDP.DecoratorDP;

public class Iphone11 extends PhoneDecorator{

    public Iphone11(Iphone basicPhone) {
        super(basicPhone);
    }

    //Iphone11 ilkel Iphonenun tüm işlevlerine sahip
    //şimdi Iphone11 e yeni işlev ekleyelelim.

    public String getModel(){
        return "11";
    }


}
