package StructuralDP.DecoratorDP;

public class PhoneDecorator implements Phone{

    private Phone basicPhone;//mevcut obje

    //param const
    public PhoneDecorator(Phone basicPhone) {
        this.basicPhone = basicPhone;
    }

    @Override
    public String getName() {
        return this.basicPhone.getName();
    }

    @Override
    public int getCameraCount() {
        return this.basicPhone.getCameraCount();
    }

    @Override
    public double getPrice() {
        return this.basicPhone.getPrice();
    }
}
