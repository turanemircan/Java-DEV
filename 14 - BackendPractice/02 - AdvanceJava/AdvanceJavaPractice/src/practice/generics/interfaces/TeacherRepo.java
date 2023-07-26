package practice.generics.interfaces;

public class TeacherRepo implements Repository<Teacher>{
    @Override
    public void add(Teacher teacher) {
        System.out.println(teacher.getName()+" başarı ile eklendi. ");
    }

    @Override
    public void get(Teacher teacher) {
        System.out.println(teacher.getName()+" başarı ile bulundu");
    }

    @Override
    public void update(Teacher teacher) {
        System.out.println(teacher.getName()+" başarı ile güncellendi.");
    }

    @Override
    public void delete(Teacher teacher) {

        System.out.println(teacher.getName()+" başarı ile silindi");
    }
}
