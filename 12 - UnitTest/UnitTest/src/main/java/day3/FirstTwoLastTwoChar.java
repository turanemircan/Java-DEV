package day3;

public class FirstTwoLastTwoChar {

    // !!! Task : ilk 2 ve son 2 karakteri ayni mi ??
    // BABA-->true , ABBA-->false, A-->false, "BC"-->true

    public boolean checkAreSameFirstTwoLastTwo(String str){//BC

         if (str.length()<=1){
             return false;
         }
         if (str.length()==2){
             return true;
         }

        String firstTwo=str.substring(0,2);//BC
        String lastTwo=str.substring(str.length()-2);//BC


       return firstTwo.equals(lastTwo);
    }


}
