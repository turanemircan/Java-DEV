package com.tpe.hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/*
1)  First Level Cache --->
            * nesne için kullanılır
            * defaultta açık geliyor , kapatma durumu yok
            * Aynı session içinde kayıt alır
            * session kapanınca içindekiler silinir

2) Second Level Cache --->
            * nesne için kullanılır
            * Defaultta kapalıdır
            * Session factory seviyesinde cacheleme yapar, yani farklı
                    sessionlar arasında data kullanılabiliyor
            * hibernate.cfg.xml den active edilebilir
            * aynı data aynı sessionda first level cacheden gelir,
              aynı data farklı sessionda second level cacheden gelir.


3) Query Cache
            * Query ler için kullanılıyor
            * hibernate.cfg.xml den active edilebilir
            * first/second level ile birlikte kullanılabilir.
 */
public class RunnerFetch12 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student12.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

//        System.out.println("İlk get işlemi ile id:1 olan student getirme");
//        Student14 student1=session.get(Student14.class,1);
//        System.out.println(student1);
//
//       // session.clear();//cache i temizler
//
//
//        System.out.println("Aynı sessionda İkinci kez get işlemi ile id:1 olan student getirme");
//        Student14 student2=session.get(Student14.class,1);
//        System.out.println(student2);


        //query cache i kullanmak için configde ayarları yaptık
        //querynin sonucunun cache e yazılması/okunması için setCacheable ı true yapmalıyız

        Query query =session.createQuery("FROM Student14").setCacheable(true);
        query.getResultList();


        Query query2=session.createQuery("FROM Student14").setCacheable(true);
        query2.getResultList();


        tx.commit();
        session.close();

        Session session2=sf.openSession();
        Transaction tx2=session2.beginTransaction();

//        System.out.println("Farklı sessionda get işlemi ile id:1 olan student getirme");
//        Student14 student3=session2.get(Student14.class,1);
//        System.out.println(student3);

        Query query3=session2.createQuery("FROM Student14").setCacheable(true);
        query3.getResultList();
        //second level cache activese DB ye gitmez

        tx2.commit();
        session2.close();
        sf.close();

        //SONUÇ:First Level Cache:
        //      aynı sessionda aynı objeyi fetch etmek istediğimizde
        //      bir kere DB ye başvurur, daha sonra cacheden getirir.
        //      session kapatılır veya clear metodu çağrılırsa cache temizlenir
        //      dolayısıyla aynı obje için tekrar DB ye başvurulur.







    }
}
