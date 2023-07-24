package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGenericType {
    public static void main(String[] args) {

        //generics ile hangi data tipini kullanacağımıza sonradan karar verebiliriz
        //Java 7 den sonra sağ tarafta data tipini belirlemeye gerek kalmadı.

        GenericClass<String> obj1=new GenericClass<>();
        obj1.setField("Generic Types");

        String str = obj1.getField();//CTE vermedi, CAST problemi kalmadı.
                                     //ClassCastExceptionı da engelledi.

        //---------------------------------

        GenericClass<String> obj2=new GenericClass<>();
      //  obj2.setField(123);//generics tür-güvenliğini sağlar

        GenericClass<Integer> obj3=new GenericClass<>();
        obj3.setField(123);

        Integer integer=obj3.getField();

       // GenericClass<double> obj4=new GenericClass<double>();--sadece NON-PRIMITIVE

        ArrayList<String> list=new ArrayList<>();
        list.add("Java");
        //list.add(12);
        String s=list.get(0);


        HashMap<String,Integer> map=new HashMap<>();
        map.put("Generics",54);
       // map.put(54,"String");


        //=====================ÇOK PARAMETRELİ CLASS===============================

        GenericClassTwoParam<String,Double> mymap=new GenericClassTwoParam<>("Generics",12.3);
        GenericClassTwoParam<Integer,Integer> mymap2=new GenericClassTwoParam<>(12,34);




    }
}
