package practice.generics.classes;

/*
---Generic Type---
Java 5 ile geldi
Farklı data type lerini ayni yapida kullanabiliyoruz
Tip güvenliği sagliyor
CTE verir
 */
//    Task 1:Java dersi için öğrencileri, isim, vize notu ve final notu ile birlikte listeleyen bir program yazınız
//    Task 2.Kütüphane için öğrencileri isim, okul no ve mail adresi ile birlikte listeleyen bir program yazınız
public class StudentList {
    public static void main(String[] args) {

        System.out.println("******Java Dersi Vize ve Final Notları***********");
        listGrade();
        System.out.println();
        System.out.println("******Kutuphane Ogrenci Listesi***********");
        listMemberLibrary();

    }
    //Ogrencileri notlarini listeleyen bir method
    public static void listGrade(){
        Student <String, Double, Double> std1=new Student<>("Joe",75.8,90.0);
        Student <String, Double, Double> std2=new Student<>("Jack",65.8,80.0);
        Student <String, Double, Double> std3=new Student<>("Avarel",45.20,60.0);

        System.out.printf("%-11s || %.2f || %.2f \n",std1.getS(),std1.getE(),std1.getV());
        System.out.printf("%-11s || %.2f || %.2f \n",std2.getS(),std2.getE(),std2.getV());
        System.out.printf("%-11s || %.2f || %.2f \n",std3.getS(),std3.getE(),std3.getV());
    }

    //Kutuphane uye listesini yazdiran bir method
    public static void listMemberLibrary(){
        Student<String,Integer,String> std1=new Student<>("William", 500, "william@gmail.com");
        Student<String,Integer,String> std2=new Student<>("Red Kit", 400, "redkit@gmail.com");
        Student<String,Integer,String> std3=new Student<>("Rin Tin Tin", 300, "rintintin@gmail.com");

        System.out.printf("%-11s || %-4d || %-20s \n",std1.getS(),std1.getE(),std1.getV());
        System.out.printf("%-11s || %-4d || %-20s \n",std2.getS(),std2.getE(),std2.getV());
        System.out.printf("%-11s || %-4d || %-20s \n",std3.getS(),std3.getE(),std3.getV());

    }

}
