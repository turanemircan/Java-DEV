package CreationalDP.AbstractFactoryDP;

public class Runner {
    public static void main(String[] args) {


        AbstractFactory<Shape> shapeFactory=FactoryProducer.getFactory("şekil");
        Shape kare=shapeFactory.getObject("kare");
        kare.draw();

        AbstractFactory<Color> colorFactory=FactoryProducer.getFactory("renk");
        Color mavi=colorFactory.getObject("mavi");
        mavi.fill();


        System.out.println("-----------------------------------------------------");

        Shape ucgen=(Shape) FactoryProducer.getFactory("şekil").getObject("üçgen");
        ucgen.draw();

        Color red=(Color)FactoryProducer.getFactory("renk").getObject("kırmızı");
        red.fill();




    }
}
