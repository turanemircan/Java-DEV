package com.tpe.recap.onetomany_uni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {//ONE

    @Id
    private int id;

    private String name;

    private int grade;

    @OneToMany//FK sütunu eklenemeyeceği için 3. bir tablo oluşturur(join table:std_id-->book_id)
    @JoinColumn(name = "student_id")//kullanıldığında FK sütunu book tablosunda oluşturur, aksi halde yukarıdaki join table oluşur.
    private List<Book06> bookList=new ArrayList<>();//MANY

    public Student06() {
    }

    //param const

    public Student06(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book06> bookList) {
        this.bookList = bookList;
    }

    //toString

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
