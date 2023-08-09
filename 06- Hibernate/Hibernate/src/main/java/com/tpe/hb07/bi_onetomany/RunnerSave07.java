package com.tpe.hb07.bi_onetomany;

import com.tpe.hb06.onetomany_uni.Book06;
import com.tpe.hb06.onetomany_uni.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Book07 book1=new Book07(101,"Math Book");
        Book07 book2=new Book07(102,"Java Book");
        Book07 book3=new Book07(103,"React Book");
        Book07 book4=new Book07(104,"C++ Book");
        Book07 book5=new Book07(105,"HTML Book");

        Student07 student1=new Student07(1001,"Ayşe",78);
        Student07 student2=new Student07(1002,"Nejla",87);
        Student07 student3=new Student07(1003,"Faruk",79);

        //student1.getBookList().add(book1);
        //her iki tarafından da set yapılabilir;
        // ancak kesinlikle owner of relation tarafında set yapmak gerekli..
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student2);




        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);
        session.persist(book5);

        System.out.println(student1.getBookList());//[]


        tx.commit();
        session.close();
        sf.close();
    }
}
