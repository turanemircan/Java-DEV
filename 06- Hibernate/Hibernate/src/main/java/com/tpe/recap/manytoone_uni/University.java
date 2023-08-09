package com.tpe.recap.manytoone_uni;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University {//One

    @Id
    private int id;

    private String name;

    public University() {
    }

    //param const

    public University(int id, String name) {
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

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
