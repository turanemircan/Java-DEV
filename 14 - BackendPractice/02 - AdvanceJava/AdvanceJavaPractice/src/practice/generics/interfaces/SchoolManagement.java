package practice.generics.interfaces;
/*Task: Okul yönetimi için öğrenci ve öğretmen kayıtlarını
     -oluşturan
     -görüntüleyen
     -güncelleyen
     -silen
     Bir program yazınız
*/

public class SchoolManagement {
    public static void main(String[] args) {
        Student student = new Student("Feyzullah");
        StudentRepo studentRepo = new StudentRepo();

        Teacher teacher = new Teacher("İsmail");
        TeacherRepo teacherRepo=new TeacherRepo();

        studentRepo.add(student);
        studentRepo.get(student);
        studentRepo.update(student);
        studentRepo.delete(student);

        System.out.println("========================================");
        teacherRepo.add(teacher);
        teacherRepo.get(teacher);
        teacherRepo.update(teacher);
        teacherRepo.delete(teacher);
    }
}
