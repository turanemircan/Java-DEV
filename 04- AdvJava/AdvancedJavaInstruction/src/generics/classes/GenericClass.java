package generics.classes;
//generic olarak PRIMITIVE data tipleri KULLANILAMAZ.
public class GenericClass<T> {
    /*
        E --> Element, collection gibi yapılarda kullanılır
        K --> Key
        V --> Value
        N --> Number
        T --> Type
        S,U,V , vb --> 2., 3. ve 4. tipler için
         */
    private T field;//fieldın referansı her data tipinde olabilir.

    //getter-setter

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }
}
