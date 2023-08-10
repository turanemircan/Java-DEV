package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

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
        String sqlQuery =
                "SELECT s.student_name,b.name FROM student07 s INNER JOIN book07 b ON s.id=b.student_id";
        List<Object[]> resulList1 = session.createSQLQuery(sqlQuery).getResultList();
        for (Object[] object : resulList1) {
            System.out.println(Arrays.toString(object));
        }
        //  aynı sorguyu HQL ile yazalım
        String hqlQuery =
                "SELECT s.name,b.name FROM Student07 s INNER JOIN Book07 b ON s.id=b.student.id";
        List<Object[]> resultList2 = session.createQuery(hqlQuery).getResultList();
        resultList2.forEach(oa -> System.out.println(Arrays.toString(oa)));
        //  book ismi içinde "Java" geçen student kayıtlarını alalım ( HQL )
        String hqlQuery6 = "SELECT s FROM Student07 s INNER JOIN Book07 b ON s.id=b.student.id WHERE b.name LIKE '%Java%'";
        String hqlQuery5 = "SELECT s FROM Student07 s INNER JOIN s.bookList b WHERE b.name LIKE '%Java%'";
        List<Student07> resultList4 = session.createQuery(hqlQuery6, Student07.class).getResultList();
        for (Student07 student07: resultList4) {
            System.out.println(student07);
        }

        tx.commit();
        session.close();
        sf.close();


    }
}
