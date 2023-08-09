package com.tpe.hb06.onetomany_uni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {

        Book06 book1=new Book06(101,"Math Book");
        Book06 book2=new Book06(102,"Java Book");
        Book06 book3=new Book06(103,"React Book");

        Student06 student1=new Student06(1001,"Süleyman",99);
        Student06 student2=new Student06(1002,"Tansu",95);
        Student06 student3=new Student06(1003,"Benna",93);



        student1.getBookList().add(book1);
        student1.getBookList().add(book2);
        student2.getBookList().add(book3);



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(student1);
        session.persist(student2);
        session.persist(student3);




        tx.commit();
        session.close();
        sf.close();


    }
}
