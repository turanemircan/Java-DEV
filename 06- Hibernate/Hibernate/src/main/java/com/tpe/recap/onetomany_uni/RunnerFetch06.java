package com.tpe.recap.onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //id:101 olan kitabı görelim
        Book06 book=session.get(Book06.class,101);
        System.out.println(book);
        //bu kitabın sahibi
        //book.getStudent()

        //id:1001 olan öğrencinin kitaplarını görelim
        Student06 student=session.get(Student06.class,1001);
        System.out.println(student.getBookList());


        //name="Süleyman" olan öğrencinin kitaplarını görelim.
        // b.id=s.bookList.id ile JOIN olmaz
        String hql="SELECT b.id, b.name FROM Student07 s INNER JOIN s.bookList b WHERE s.name='Süleyman'";
        List<Object[]> resultList=session.createQuery(hql).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));






        tx.commit();
        session.close();
        sf.close();
    }
}
