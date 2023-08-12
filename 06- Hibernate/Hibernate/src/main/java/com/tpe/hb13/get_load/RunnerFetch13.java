package com.tpe.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
   get -> dönen objeye hemen ihtiyaç duyulursa get kullanılır.
       -> hemen db ye başvurur
       -> obje yoksa null döner
       -> id ile obje olduğuna emin değilsek get kullanılmalı

   load -> proxy(gölge) döner
        -> hemen db ye başvurmaz->ne zaman ihtiyaç duyulursa gerçek nesneyi döner
        -> obje yoksa not found exception fırlatır
        -> id ile obje olduğuna eminsek load kullanılmalı
        -> objeye reference olarak ihtiyaç duyulursa kullanılmalı

 */

public class RunnerFetch13 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student13.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //get
//        System.out.println("++++++++++++++get metodu başlangıç");
//        Student14 student1=session.get(Student14.class,1);
//        System.out.println("++++++++++++++get metodu bitiş");
//        System.out.println("ID: "+student1.getId());
//        System.out.println("Name: "+student1.getName());

        //load
//        System.out.println("++++++++++++++load metodu başlangıç");
//        Student14 student2=session.load(Student14.class,1);
//        System.out.println("++++++++++++++load metodu bitiş");
//        System.out.println("ID: "+student2.getId());
//        System.out.println("Name: "+student2.getName());

        //olmayan id ile obje fetch edelim
//        Student14 student3=session.get(Student14.class,50);
//        //System.out.println(student3.getId());
//        if(student3!=null){
//                    System.out.println("ID: "+student3.getId());
//                    System.out.println("Name: "+student3.getName());
//        }

        Student13 student4=session.load(Student13.class,50);
        System.out.println(student4.getId());
        System.out.println(student4.getName());//objectnotfoundexception



        tx.commit();
        session.close();
        sf.close();


    }

}
