package StructuralDP.DecoratorDP;

public class Runner {

    public static void main(String[] args) {

        System.out.println("-----------------Mevcut Obje --------------");

        Iphone iphone=new Iphone();
        System.out.println(iphone.getName());
        System.out.println(iphone.getCameraCount());
        System.out.println(iphone.getPrice());

        System.out.println("-----------------Dekore Edilmiş Obje --------------");
//        Iphone basicPhone=new Iphone();
//        Iphone11Pro iphone11Pro=new Iphone11Pro(basicPhone);

        Iphone11Pro iphone11Pro=new Iphone11Pro(new Iphone());
        System.out.println(iphone11Pro.getName());
        System.out.println(iphone11Pro.getModel());
        System.out.println(iphone11Pro.getCameraCount());
        System.out.println(iphone11Pro.getPrice());
        iphone11Pro.roundCorner();

        System.out.println("-----------------Pro Max --------------");

        Iphone11ProMax iphone11ProMax=new Iphone11ProMax(new Iphone());
        System.out.println(iphone11ProMax.getModel());
        System.out.println(iphone11ProMax.addColor());


    }

}
