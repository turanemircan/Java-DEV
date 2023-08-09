package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch007 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //tüm studentları silebilir miyiz?EVET ama aşamalı olarak silebiliriz
        //öncelikle tüm kitapları silelim
//        String hql="DELETE FROM Book07";
//        int numOfRecord=session.createQuery(hql).executeUpdate();
//        System.out.println("silinen kayıt sayısı : "+numOfRecord);
//
//        String hql2="DELETE FROM Student07";
//        int numOfRecord2=session.createQuery(hql2).executeUpdate();
//        System.out.println("silinen kayıt sayısı : "+numOfRecord2);
//
//        //name:C++ Book olan kitabı silelim.
//        String hql3="DELETE FROM Book07 b WHERE b.name='C++ Book'";
//        int numOfRecord3=session.createQuery(hql2).executeUpdate();
//        System.out.println("silinen kayıt sayısı : "+numOfRecord3);


        //--------------------------------------------------------------------------------------

        //kitabı olan bir öğrenciyi silmek istersek
        //1-öğrencinin ilişkili olduğu kitapları silip sonra öğrenciyi silebiliriz.
        //2-cascade = CascadeType.REMOVE/orphanRemoval

        //id:1001 olan studentı silelim.
        Student07 student1=session.get(Student07.class,1001);
        session.delete(student1);


        //orphanRemoval ın farkı:???







        tx.commit();
        session.close();
        sf.close();


    }
}
