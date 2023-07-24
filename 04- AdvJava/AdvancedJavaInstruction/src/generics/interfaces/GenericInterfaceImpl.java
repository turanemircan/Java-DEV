package generics.interfaces;
//1.Seçenek:Generic interface i implemente eden class da generic olmalı
public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    @Override
    public void print(T value) {

    }

    @Override
    public T find() {
        return null;
    }
}
