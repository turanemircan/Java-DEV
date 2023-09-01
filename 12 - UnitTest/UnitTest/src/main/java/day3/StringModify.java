package day3;

public class StringModify {

    // Task : kelimenin ilk 2 harf icerisinde A varsa silinsin (kelime içindeki harflerin hepsi büyük olacak)
    // AABC --> BC  , ABC --> BC , A  --> "" , AA --> "", ABABC-->BABC

    public String deleteIfAIsInTwoPosition(String str){

        if (str.length()<=2){//AA->"",AB->B
            return str.replaceAll("A","");
        }

        String firstTwoChars=str.substring(0,2);//AABCD->AA
        String afterTwoChars=str.substring(2);


        return firstTwoChars.replaceAll("A","")+afterTwoChars;
    }


}
