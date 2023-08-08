package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {


        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //id:1001 olan studentı
        Student04 student=session.get(Student04.class,1001);
        System.out.println("Student 1in diarysi: "+student.getDiary());//studentdan diarye ulaşabiliyoruz...

        //id:11 olan diary
        Diary04 diary=session.get(Diary04.class,11);
        System.out.println("1.diarynin sahibi :"+diary.getStudent());

        //bi_directional ilişkide uygulamamızda kodlar ile her bir objeden diğerine ulaşabiliriz.
        //bi/uni directional ilişkide DB deki tablolar açısından fark yoktur.


        // !!! Task 1: Diary ve Student tablolarında ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.

        String hql="SELECT s.name, d.name FROM Student04 s INNER JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList=session.createQuery(hql).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));

        // !!! Task 2: Student tablosunda tüm kayıtlar için
        //student name ve diary name fieldlarını getirelim.
        String hql2="SELECT s.name, d.name FROM Student04 s LEFT JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList2=session.createQuery(hql2).getResultList();
        resultList2.forEach(t-> System.out.println(Arrays.toString(t)));

        // !!! Task 3:Tüm günlükler ve  Günlüğü olan studentların name ve diary name fieldlarını getirelim.
        String hql3="SELECT s.name, d.name FROM Student04 s RIGHT JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList3=session.createQuery(hql3).getResultList();
        resultList3.forEach(t-> System.out.println(Arrays.toString(t)));

        // !!! Task 4:Diary ve Student tablosunda tüm kayıtlar için
        //student name ve diary name fieldlarını getirelim.
        String hql4="SELECT s.name, d.name FROM Student04 s FULL JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList4=session.createQuery(hql4).getResultList();
        resultList4.forEach(t-> System.out.println(Arrays.toString(t)));






        tx.commit();
        session.close();
        sf.close();

    }
}
