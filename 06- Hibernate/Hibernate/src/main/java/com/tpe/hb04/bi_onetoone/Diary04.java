package com.tpe.hb04.bi_onetoone;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary04 {//owner of relation,ilişki sahibi

    @Id//PK
    private int id;

    private String name;

    @OneToOne//student tablosunun PK sütununu kullanrak Diary tablosunda FK sütunu oluşturur. Default:student_id
    @JoinColumn(name = "std_id",unique = true)//opsiyonel
    private Student04 student;

    //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
               /* ", student=" + student +*/
                '}';
    }
}
