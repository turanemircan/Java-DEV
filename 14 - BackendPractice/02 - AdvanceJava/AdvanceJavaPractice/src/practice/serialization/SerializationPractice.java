package practice.serialization;

import java.io.*;

// Task:Book tipinde nesneler üretip bu nesneleri
//books.txt dosyasına kaydedin ve sonra bu dosyadan
//nesneleri okuyun
public class SerializationPractice {
    public static void main(String[] args) {
     // writeObjects();
        readObject();

    }
    public static void writeObjects(){

        //Once txt dosyasına kaydedecegimiz kitaplari olustur
        Book book1=new Book("Şeker Portakalı","Jose Mouro",1980);
        Book book2=new Book("Dune","Frank Herbert",1965);
        Book book3=new Book("Simyacı","Paulo Coelho",1988);

        try {
            FileOutputStream fos=new FileOutputStream("books.txt");
            ObjectOutputStream write=new ObjectOutputStream(fos);
            write.writeObject(book1);
            write.writeObject(book2);
            write.writeObject(book3);

            write.close();
            fos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readObject(){

        try {
            //nesneleri okunacak dosyayi al
            FileInputStream fis=new FileInputStream("books.txt");

            //nesneleri okumak icin
            ObjectInputStream read=new ObjectInputStream(fis);
            Book book1=(Book)read.readObject();
            Book book2=(Book)read.readObject();
            Book book3=(Book)read.readObject();

            System.out.println(book1);
            System.out.println(book2);
            System.out.println(book3);

            fis.close();
            read.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
