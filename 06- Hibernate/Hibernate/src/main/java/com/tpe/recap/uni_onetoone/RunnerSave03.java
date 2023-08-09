package com.tpe.recap.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student1=new Student03(1001,"Yahya",97);
        Student03 student2=new Student03(1002,"Songül",98);
        Student03 student3=new Student03(1003,"Nejla",99);

        Diary diary1=new Diary();
        diary1.setId(11);
        diary1.setName("Yahya's Diary");
        diary1.setStudent(student1);//1001

        Diary diary2=new Diary();
        diary2.setId(12);
        diary2.setName("Songül's Diary");
        diary2.setStudent(student2);//1002

        Diary diary3=new Diary();
        diary3.setId(13);
        diary3.setName("X's Diary");
        //diary3.setStudent(student1);



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);

        session.persist(diary1);
        session.persist(diary2);
        session.persist(diary3);


        tx.commit();
        session.close();
        sf.close();

    }
}
