package com.tpe.recap.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {//owner of relation,ilişki sahibi

    @Id//PK
    private int id;

    private String name;

    @OneToOne//student tablosunun PK sütununu kullanrak Diary tablosunda FK sütunu oluşturur. Default:student_id
    @JoinColumn(name = "std_id",unique = true)//opsiyonel
    private Student03 student;

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
