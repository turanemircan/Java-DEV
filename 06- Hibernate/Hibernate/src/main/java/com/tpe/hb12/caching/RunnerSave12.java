package com.tpe.hb12.caching;

import com.tpe.hb11.criteriaapi.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerSave12 {
    public static void main(String[] args) {

        Student12 student1 = new Student12();
        student1.setName("Jack Sparrow");
        student1.setGrade(88);

        Student12 student2 = new Student12();
        student2.setName("Harry Potter");
        student2.setGrade(99);

        Student12 student3 = new Student12();
        student3.setName("Sherlock Holmes");
        student3.setGrade(100);



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student12.class);


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
