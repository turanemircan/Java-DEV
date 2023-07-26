package practice.generics.interfaces;

public class StudentRepo implements Repository <Student> {
    @Override
    public void add(Student student) {
        System.out.println(student.getName()+" başarı ile eklendi. ");
    }

    @Override
    public void get(Student student) {
        System.out.println(student.getName()+" başarı ile bulundu");
    }

    @Override
    public void update(Student student) {
        System.out.println(student.getName()+" başarı ile güncellendi.");

    }

    @Override
    public void delete(Student student) {
        System.out.println(student.getName()+" başarı ile silindi");

    }
}
