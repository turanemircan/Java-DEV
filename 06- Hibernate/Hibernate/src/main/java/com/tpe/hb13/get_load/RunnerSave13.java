package com.tpe.hb13.get_load;

import com.tpe.hb12.caching.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1 = new Student13();
        student1.setName("Jack Sparrow");
        student1.setGrade(88);

        Student13 student2 = new Student13();
        student2.setName("Harry Potter");
        student2.setGrade(99);

        Student13 student3 = new Student13();
        student3.setName("Sherlock Holmes");
        student3.setGrade(100);



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student13.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);



        tx.commit();
        session.close();
        sf.close();


    }

}
