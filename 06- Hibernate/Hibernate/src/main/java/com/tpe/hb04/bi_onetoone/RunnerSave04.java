package com.tpe.hb04.bi_onetoone;

import com.tpe.hb03.uni_onetoone.Diary;
import com.tpe.hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student1=new Student04();
        student1.setId(1001);
        student1.setName("Benna");
        student1.setGrade(98);

        Student04 student2=new Student04();
        student2.setId(1002);
        student2.setName("Merve");
        student2.setGrade(98);

        Student04 student3=new Student04();
        student3.setId(1003);
        student3.setName("Enes");
        student3.setGrade(98);
       // student3.setDiary();

        Diary04 diary1=new Diary04();
        diary1.setId(11);
        diary1.setName("A Diary");
        diary1.setStudent(student1);

        Diary04 diary2=new Diary04();
        diary2.setId(22);
        diary2.setName("B Diary");
        diary2.setStudent(student2);

        Diary04 diary3=new Diary04();
        diary3.setId(33);
        diary3.setName("C Diary");

        //bi_directionalda:kesinlikle ilişki sahibi tarafında diğer obje set edilmeli
        //aksi takdirde FK de sadece null değerler olur ve ilişki kurulamaz
        //yani Diary tarafında



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);

        session.persist(diary1);
        session.persist(diary2);
        session.persist(diary3);

        System.out.println("Student 1in diarysi:"+student1.getDiary());
        System.out.println("1.Günlüğün sahibi :"+diary1.getStudent());




        tx.commit();
        session.close();
        sf.close();

    }
}
