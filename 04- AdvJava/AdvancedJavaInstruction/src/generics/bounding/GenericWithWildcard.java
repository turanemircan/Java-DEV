package generics.bounding;

import generics.classes.GenericClass;

import java.util.ArrayList;
import java.util.List;


//wildcard(joker:?)=bilinmeyen data tipi
public class GenericWithWildcard {
    public static void main(String[] args) {

        List<Object> objectList=new ArrayList<>();
        List<String> stringList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();
        List<Integer> integerList=new ArrayList<>();
        List<Double> doubleList=new ArrayList<>();


        System.out.println("------------------wildcard ile alttan sınırlama----------------------------");
        addElements(integerList);
        System.out.println(integerList);
        addElements(numberList);
        addElements(objectList);
        //addElements(stringList);-->CTE, String integerın parentı değil
        //addElements(doubleList);-->Double,integerın parentı değil
        GenericClass<? super Double> object=new GenericClass<>();//Double ve superlarını kullanabiliriz.
        object.setField(12.0);
        System.out.println("------------------wildcard ile üstten(upperbound) sınırlama----------------------------");
        multiplByTwo(integerList);
        multiplByTwo(doubleList);
        multiplByTwo(numberList);
        //multiplByTwo(objectList);-->Number ile üstten sınırlama yaptık

        System.out.println("------------------List<?>----------------------------");
        printElements(objectList);
        printElements(stringList);
        printElements(doubleList);

        System.out.println("------------------List<Object>----------------------------");
        printElementsObject(objectList);
        //printElementsObject(stringList);-->List<Object>, List<String> in parentı değildir.



    }

    //alttan sınırlama(lower bound)
    //Integer veya Integer ın parentları ile oluşturulan listeye
    // 1 den 10(dahil) a kadar eleman ekleyen bir metod
    //Integer,Number,Object
    public static void addElements(List<? super Integer> list){
        for (int i=1; i<=10; i++){
            list.add(i);
        }
    }

    //üstten sınırlama(lower bound)
    public static void multiplByTwo(List<? extends Number> list){
        //list.add(1);-->listede değişikliğe izin vermez
        list.stream().map(t->2*t.doubleValue()).forEach(t-> System.out.print(t+" "));

    }

    public static void printElements(List<?> unknownList){

        //unknownList.add("Java");
        //wildcard sebebiyle data türü net olmadığı için add gibi metodlara
        //izin vermez.(read-only)

        unknownList.add(null);

        for (Object o:unknownList){
            System.out.println(o);
        }

        System.out.println(unknownList.size());
        //data tipinden bağımsız metodlar kullanılabilir;size,remove,clear

    }
//List<?> ile List<Object> farkı
    public static void printElementsObject(List<Object> unknownList){

        unknownList.add("Java");

        for (Object o:unknownList){
            System.out.println(o);
        }

        System.out.println(unknownList.size());
        //data tipinden bağımsız metodlar kullanılabilir;size,remove,clear

    }

  //NOT:List<T> ile List<?> tamamen aynı değildir.




}
