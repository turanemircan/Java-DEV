package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        Student07 student=session.get(Student07.class,1001);
        System.out.println(student.getBookList());

        System.out.println("-------------------------------------------");
        Book07 book=session.get(Book07.class,101);
        System.out.println(book.getStudent());


        //PRACTICE
        //  SQL ile, kitabı olan öğrencilerin öğrenci ve kitap isimlerini listeleyelim
        //  aynı sorguyu HQL ile yazalım
        //  book ismi içinde "Java" geçen student kayıtlarını alalım ( HQL )


        tx.commit();
        session.close();
        sf.close();


    }
}
