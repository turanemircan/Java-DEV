package com.tpe.hb07.bi_onetomany;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student07")
public class Student07 {//ONE

    @Id
    private int id;

    private String name;

    private int grade;

  //  @OneToMany(mappedBy = "student",cascade = CascadeType.REMOVE)
    @OneToMany(mappedBy = "student",orphanRemoval = true)
    private List<Book07> bookList=new ArrayList<>();//MANY

    public Student07() {
    }

    //param const

    public Student07(int id, String name, int grade) {
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

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
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
