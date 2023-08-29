package CreationalDP.FactoryDP;

public class Runner {
    public static void main(String[] args) {

        Shape triangle=new Triangle("Ucgen",60,3);
        triangle.draw();

        Shape square=new Square("kare",90,4);
        square.draw();

        Shape pentagon=new Pentagon("beşgen",108,5);
        pentagon.draw();

//objenin contructor/domain hk bilgimiz olmadan, objeyi burada kullanmak istiyoruz
//bunun için factory method dp kulanılmalı

        System.out.println("------------------------------------------------");

        Shape shape1=ShapeFactory.getShape(ShapeType.UCGEN);
        shape1.draw();

        Shape shape2=ShapeFactory.getShape(ShapeType.KARE);
        shape2.draw();

        //artık new keywordünü kullanmadığımız için classımız Square/Triangle objelerine
        //sıkı sıkıya bağımlı değil


    }
}
