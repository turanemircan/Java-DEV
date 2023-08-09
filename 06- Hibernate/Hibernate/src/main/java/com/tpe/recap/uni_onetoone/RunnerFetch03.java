package com.tpe.recap.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //id:1002 olan studentı görelim
        Student03 student=session.get(Student03.class,1002);
        System.out.println(student);
        //student.getDiary();?????

//        ÖDEV: Uni-directional ilişki olan Student03 ve Diary classlarında
//        id si 1001 olan studentin diaryi bilgilerini getiren bir SQL ve HQL sorgusu yazınız..
//        RunnerFetch03  classı kullanılabilir.


        System.out.println("----------------------------------------");

        //id:12 olan diaryi görelim
        Diary diary=session.get(Diary.class,12);
        System.out.println(diary);//12,Songül's Diary,student:{id,name,...}

        //id:11 olan diaryinin sahibi olan studentı görelim
        Diary diary2=session.get(Diary.class,11);
        System.out.println("id:11 olan diarynin sahibi: "+diary2.getStudent());

        //Java kodlarıyla diaryden studenta ulaşabiliyoruz.
        //studentdan diarye ulaşamıyoruz.???


        tx.commit();
        session.close();
        sf.close();




    }
}
