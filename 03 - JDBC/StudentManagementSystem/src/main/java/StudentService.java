import java.util.Scanner;

//3-Student ile ilgili methodlar icin StudentService classi olusturuldu
public class StudentService {


    // 9-reponun methodlarini kullnmak icin obje olustur
    Scanner inp=new Scanner(System.in);
    StudentRepository repository=new StudentRepository();

    //10-Tablo olusturmak icin method
    public void createTable(){
        repository.createTable();
    }

    //11-Öğrenci kaydetme
    public void saveStudent(){
        System.out.println("Ad : ");
        String name=inp.nextLine().trim();
        System.out.println("Soyad : ");
        String lastname=inp.nextLine().trim();
        System.out.println("Şehir : ");
        String city=inp.nextLine().trim();
        System.out.println("Yaş : ");
        int age=inp.nextInt();
        inp.nextLine();
        Student newStudent=new Student(name,lastname,city,age);
        repository.save(newStudent);

    }

    //13-tüm ğrencileri listele
    public void getAllStudents(){
        repository.findAll();
    }

    //15-Öğrenciyi silme
    public void deleteStudent(int id){
        repository.delete(id);
    }



}
