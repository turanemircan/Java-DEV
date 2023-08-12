package com.tpe.recap.bi_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book07 {//many:owner relation

    @Id
    private int id;

    private String name;

    @ManyToOne
    //@JoinColumn(name = "std_id")-->OPSIYONEL-->diğer classta mappedby old için FK burada oluşur.
    private Student07 student;//one

    public Book07() {
    }

    //param const
    public Book07(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //getter-setter


    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

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
    //toString

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
