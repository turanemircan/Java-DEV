package CreationalDP.AbstractFactoryDP;

public class ColorFactory implements AbstractFactory<Color>{

    @Override
    public Color getObject(String objectType) {
        return getColor(objectType);
    }

    public Color getColor(String color){
        if (color.equalsIgnoreCase("kırmızı")){
            return new Red();
        } else if (color.equalsIgnoreCase("mavi")) {
            return new Blue();
        } else if (color.equalsIgnoreCase("yeşil")) {
            return new Green();
        }
        return null;
    }



}
