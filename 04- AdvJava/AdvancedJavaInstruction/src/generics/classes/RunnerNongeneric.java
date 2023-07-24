package generics.classes;

public class RunnerNongeneric {

    public static void main(String[] args) {

        //2 tane farklı obje
        NonGenericType obj1=new NonGenericType();
        NonGenericType obj2=new NonGenericType();

        obj1.setField("Advanced Java");//field String ile set ettik
        obj2.setField(123);//field Integer ile set ettik


        String string=(String) obj1.getField();//CTE-->CAST problemi
        System.out.println(string);

        String str=(String) obj2.getField();//CTE-->CAST problemi, castten sonra CTE yok
        System.out.println(str);//ClassCastException!!


    }

}
