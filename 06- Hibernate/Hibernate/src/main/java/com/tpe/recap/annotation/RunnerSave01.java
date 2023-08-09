package com.tpe.recap.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        Student01 student1=new Student01();
        student1.setId(1001);
        student1.setName("Ummü Umare");
        student1.setGrade(98);
        student1.setAge(25);


        Student01 student2=new Student01();
        student2.setId(1002);
        student2.setName("Benna");
        student2.setGrade(99);
        student2.setAge(30);

        Student01 student3=new Student01();
        student3.setId(1003);
        student3.setName("Hasan");
        student3.setGrade(95);
        student3.setAge(30);



        //hibernate.cfg.xml dosyamızdaki bilgilere ve Student01 classındaki annotasyonalara göre konfigürasyon yapılır.
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        //addAnnotatedClass ile Entity classımızı Hibernate e gösteriyoruz.

        //tüm uygulamada sadece bir tane sf kullanılır. fakat farklım işlemller için birden fazla session açılabilir.
        SessionFactory sf =configuration.buildSessionFactory();//DB ile ilgili işlemlerin yönetimini sağlar.
        Session session =sf.openSession();//DB de CRUD op. için ve sorguları çalıştırmak için metodlar içerir
        //hibernate auto-commit:false
        Transaction tx =session.beginTransaction();//DB de bir transaction başlatır.

        //INSERT INTO ...
        session.persist(student1);
        session.persist(student2);
        session.persist(student3);


        tx.commit();
        session.close();
        sf.close();

    }
}
