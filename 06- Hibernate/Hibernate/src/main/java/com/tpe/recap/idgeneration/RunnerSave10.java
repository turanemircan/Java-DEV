package com.tpe.recap.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {


        Student10 student1=new Student10("Donatello",99);
        Student10 student2=new Student10("Raphael",99);
        Student10 student3=new Student10("Raphael",99);
        Student10 student4=new Student10("Raphael",99);
        Student10 student5=new Student10("Raphael",99);
        Student10 student6=new Student10("Raphael",99);

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student10.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
        session.persist(student4);
        session.persist(student5);
        session.persist(student6);

        //1000,1001,1002,1003,1004,1005
        //1006,1007,1008,1009,1010
        //1011...1015
        //10016


        tx.commit();
        session.close();
        sf.close();


    }
}
