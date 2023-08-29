package StructuralDP.DecoratorDP;

public class Iphone11ProMax extends Iphone11Pro{
    public Iphone11ProMax(Iphone basicPhone) {
        super(basicPhone);
    }

    //Iphone11pro in getModel işlevini değiştirebiliriz.

    @Override
    public String getModel() {
        return super.getModel() + " Max";
    }


    //Iphone11Pro nun işlevlerine artı olarak yeni bir işlev ekleyelim

    public String addColor(){
        return "GOLD";
    }
}
