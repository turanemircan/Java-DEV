package CreationalDP.AbstractFactoryDP;

public interface AbstractFactory<T> {

    T getObject(String objectType);


}
