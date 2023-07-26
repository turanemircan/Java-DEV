package enumTypes;


import static enumTypes.PasswordStrengthConstant.*;
import static enumTypes.PasswordStrengthConstant.HIGH;

public class Runner {
    public static void main(String[] args) {

        useConstant("LOW");
        useConstant("HIGH");
        useConstant("medium");//CTE yok, RTE yok...
        useConstant("yüksek");//CTE yok, RTE yok...

        System.out.println("-------------ENUM---------------------------");

        useEnum(PasswordStrengthEnum.LOW);
        useEnum(PasswordStrengthEnum.MEDIUM);
/*        useEnum(PasswordStrengthEnum.high);
        useEnum("high");
        useEnum(123);*/

        //sadece sınırlı değerler olan enumları kullanmaya zorluyor...





    }

    public static void useConstant(String strength){
        switch (strength){
            case LOW:
                System.out.println("Password gücünüz düşüktür!!!");
                break;
            case MEDIUM:
                System.out.println("Password gücünüz orta seviyededir!!!");
                break;
            case HIGH:
                System.out.println("Password gücünüz yüksektir!!!");
                break;
            default:
                System.out.println("Hatalı giriş!");
                break;

        }
    }

    public static void useEnum(PasswordStrengthEnum strength){
        switch (strength){
            case LOW:
                System.out.println("Password gücünüz düşüktür!!!");
                System.out.println("Seviye:"+strength.getLevel());
                break;
            case MEDIUM:
                System.out.println("Password gücünüz orta seviyededir!!!");
                break;
            case HIGH:
                System.out.println("Password gücünüz yüksektir!!!");
                break;

        }

        System.out.println("Enum ismi: "+strength.name());
        System.out.println("Enum sırası : "+strength.ordinal());

    }



}
