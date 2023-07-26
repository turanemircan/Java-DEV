package practice.generics.classes;

public class Student <S,E,V>{

    private S s;
    private E e;
    private V v;

    public Student(S s, E e, V v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
