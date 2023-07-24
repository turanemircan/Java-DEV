package generics.interfaces;
//2.Seçenek:Generic interface i implemente eden class da generic değilse interfacein data tipi belirtilmeli
public class GenericInterfaceStringImpl implements GenericInterface<String> {
    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }
}
