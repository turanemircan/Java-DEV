package CreationalDP.FactoryDP;

public class ShapeFactory {

    public static Shape getShape(ShapeType type){
        if (type==ShapeType.UCGEN){
            return new Triangle("Üçgen",60,3);
        } else if (type==ShapeType.KARE) {
            return new Square("Kare",90,4);
        } else if (type==ShapeType.BESGEN) {
            return new Pentagon("Beşgen",108,5);
        }
       return null;
    }


}
