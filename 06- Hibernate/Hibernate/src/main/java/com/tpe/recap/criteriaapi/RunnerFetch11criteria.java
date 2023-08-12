package com.tpe.recap.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11criteria {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student11.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();
        //Criteria API
        //SQL-HQL string bazlı-->hataya açık
        //criteria api:java kodlarını kullanarak programatik sorgulama
        //hatalar azalır ve derleme anında hata almamızı sağlar
        //Hibernate criteria api deprecate oldu JPA criteria api
        //Read:CriteriaQuery(select)
        //Update:CriteriaUpdate
        //Delete:CriteriaDelete

        //select * from student11

        CriteriaBuilder cb =session.getCriteriaBuilder();//cb ile CriteriaQuery oluşturmak için ve
                                                         //cb ın metodlarını kullanabilmek için

        CriteriaQuery<Student11> criteriaQuery=cb.createQuery(Student11.class);
                                                 //parametrede sonuçtaki kayıtların data tipini belirleriz.

        Root<Student11> root =criteriaQuery.from(Student11.class);

        //1.Örnek: Student11 den tüm kayıtları görelim.
        criteriaQuery.select(root);//select * from student11
        //criteriaquery hazır, şimdi çalıştıralım.
        List<Student11> resultList=session.createQuery(criteriaQuery).getResultList();
//        resultList.forEach(System.out::println);

        //!!! 2.Örnek , Student ismi "Student 6" olan öğrenci bilgilerini getirelim
        criteriaQuery.select(root).//select * from student11
                      where(cb.equal(root.get("name"),"Student 6"));//where name="Student 6"

        List<Student11> resultList2=session.createQuery(criteriaQuery).getResultList();
        resultList2.forEach(System.out::println);

        //!!! 3.Örnek, grade değeri 80 den büyük olan öğrenci bilgilerini getirelim

        criteriaQuery.select(root).
                where(cb.greaterThan(root.get("grade"),80));

        List<Student11> resultList3=session.createQuery(criteriaQuery).getResultList();
        resultList3.forEach(System.out::println);

        //!!! 4.Örnek grade değeri 95 den küçük olan öğrenci bilgilerini getirelim

        criteriaQuery.select(root).
                where(cb.lessThan(root.get("grade"),95));

        List<Student11> resultList4=session.createQuery(criteriaQuery).getResultList();
        resultList3.forEach(System.out::println);

        // !!! 5. örnek : id si 1 veya grade değeri i 90 dan büyük olan kayıtları bulalım

        Predicate predicate1 =cb.equal(root.get("id"),1);
        Predicate predicate2 =cb.greaterThan(root.get("grade"),90);
        Predicate predicateOr=cb.or(predicate1,predicate2);

        criteriaQuery.select(root).
                     where(predicateOr);

        //ismi Student 1 olan kaydı silelim.(CriteriaDelete)
        //ismi Student 3 olan kaydın sadece name ve grade bilgilerini görelim.(CriteriaQuery<Object[]>)






        tx.commit();
        session.close();
        sf.close();



    }
}
