package generics.classes;

public class GenericClassTwoParam<S,U> {

    private S field;

    private U value;

    //param const

    public GenericClassTwoParam(S field, U value) {
        this.field = field;
        this.value = value;
    }


    //getter-setter

    public S getField() {
        return field;
    }

    public void setField(S field) {
        this.field = field;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }
}
