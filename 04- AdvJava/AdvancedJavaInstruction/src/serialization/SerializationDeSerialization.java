package serialization;

import java.io.*;

public class SerializationDeSerialization {
    public static void main(String[] args) {

        //writeObject();
        readObject();

    }

    //objeleri dosyaya yazdırmak için metod

    public static void writeObject(){
        System.out.println("User objeleri oluşturuluyor...");
        User user1=new User(10L,"Mahmut","123456");
        User user2=new User(11L,"Ferit","123455");
        User user3=new User(12L,"Necmi","123457");
        User user4=new User(13L,"Şaban","123458");

        //FOS, verileri dosyaya yazdırma işlemi yapar
        try {
            FileOutputStream fos=new FileOutputStream("user.txt");
            //nesne yazmak için
            ObjectOutputStream output=new ObjectOutputStream(fos);
            //ObjectOutputStream ile nesneleri yazdırabilmek için bu nesnelerin serileştirilmesi gerekir.

            output.writeObject(user1);
            output.writeObject(user2);
            output.writeObject(user3);
            output.writeObject(user4);

            output.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //user.txt dosyasından objeleri okuyalım
    public static void readObject(){
         //FIS, dosyadan veri okumayı sağlar
        try {
            FileInputStream fis=new FileInputStream("user.txt");
            //nesneleri okumak için
            ObjectInputStream input=new ObjectInputStream(fis);

            User user1=(User)input.readObject();
            User user2=(User)input.readObject();
            User user3=(User)input.readObject();
            User user4=(User)input.readObject();

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);

            input.close();
            fis.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}
