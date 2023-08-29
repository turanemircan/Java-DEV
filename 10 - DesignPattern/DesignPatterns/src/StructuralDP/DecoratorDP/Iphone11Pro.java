package StructuralDP.DecoratorDP;

public class Iphone11Pro extends PhoneDecorator{

    public Iphone11Pro(Iphone basicPhone) {
        super(basicPhone);
    }

    public String getModel(){
        return "11 Pro";
    }

    public void roundCorner(){
        System.out.println("corners are rounded");
    }

}
