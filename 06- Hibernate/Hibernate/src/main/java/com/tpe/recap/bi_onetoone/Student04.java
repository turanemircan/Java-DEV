package com.tpe.recap.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_student04")
public class Student04 {//owner 1001


    @Id//entity annotasyonu kullanıldığında kullanımı zorunludur, PK sütununun belirlenmesini sağlar
    private int id;

    @Column(name = "std_name",length = 100,nullable = false,unique = true)//opsiyonel
    private String name;

    private int grade;



    @OneToOne//sadece diary tablosunda FK oluşturur.mapped by kullanılmazsa her iki tabloda FK olur.
    private Diary04 diary;//11

    public Student04() {
    }


    //getter-setter


    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", diary=" + diary +
                '}';
    }
}
