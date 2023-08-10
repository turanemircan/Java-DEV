package com.tpe.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

    /*
    2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :

    OneToMany       --> LAZY
    ManyToMany      --> LAZY
    OneToOne        --> EAGER
    ManyToOne       --> EAGER
    */

public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();


        Student09 student=session.get(Student09.class,1001);//student
       // System.out.println(student.getBookList());

       Book09 book=session.get(Book09.class,101);//book+student
       // System.out.println(book.getStudent());


        tx.commit();
        session.close();

        System.out.println(book.getStudent());
        //book EAGER iken ilişkili olan nesneleri de getirdiği için tekrar DB ye gitmesine gerek yok.
        System.out.println(student.getBookList());
        //student LAZY iken sadece studentı getirir.session kapalı old için tekrar sorgu yapamaz ve kitapları getiremez.

        sf.close();


    }
}


























