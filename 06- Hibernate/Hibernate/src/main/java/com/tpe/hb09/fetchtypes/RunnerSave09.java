package com.tpe.hb09.fetchtypes;

import com.tpe.hb08.manytomany.Course08;
import com.tpe.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {

        Student09 student1 = new Student09(1001,"Ali",70);
        Student09 student2 = new Student09(1002,"Veli",70);
        Student09 student3 = new Student09(1003,"Can",70);
        Student09 student4 = new Student09(1004,"Deniz",70);

        Book09 book1 = new Book09(101,"A Book");
        Book09 book2 = new Book09(102,"B Book");
        Book09 book3 = new Book09(103,"C Book");
        Book09 book4 = new Book09(104,"D Book");
        Book09 book5 = new Book09(105,"E Book");

        //ilişki sahibi tarafında set edilmeli
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);

        //book classında cascadeType.ALL old. için booku kaydederken ilişkili old. studentı da ekledi.
        //cascadeType ilişki sahibi olmayan tarafta kullanılırsa, iki taraftan da set yapılmalı





        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);
        session.persist(book5);


        tx.commit();
        session.close();
        sf.close();

    }
}
