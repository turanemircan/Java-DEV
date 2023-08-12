package com.tpe.recap.manytomany;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course08 {//MANY

    @Id
    private int id;

    private String name;

    @ManyToMany(mappedBy = "courseList")
    private List<Student08> studentList=new ArrayList<>();//MANY//s1

    public Course08() {
    }

    //param const

    public Course08(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Student08> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student08> studentList) {
        this.studentList = studentList;
    }

    //toString

    @Override
    public String toString() {
        return "Course08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
