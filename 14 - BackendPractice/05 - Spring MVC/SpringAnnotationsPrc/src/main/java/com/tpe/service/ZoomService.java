package com.tpe.service;

import com.tpe.domain.Course;
import com.tpe.repository.Repository;
import com.tpe.thirdparty.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Singleton")
public class ZoomService implements CourseService {

    //thirdparty bir methodu classına ihtiyaç duyarsak
    @Autowired
    private InstructorService instructorService;

//    @Autowired //Repository iinjekte etmiş oluyoruz.
//    @Qualifier("cloudRepository") //Repository i implements eden classı belirtmiş oluyoruz
//    private Repository repository;

   // injection işlemi 3 tarzda olur. 1.field oluşturarak 2.setleme 3.constructor
//   @Autowired
//   @Qualifier("cloudRepository")
//   private Repository repository;
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }

//    @Autowired //optional
//    @Qualifier("cloudRepository")
    private Repository repository;
    @Autowired
    public ZoomService(@Qualifier("cloudRepository")Repository repository) {
        this.repository = repository;
    }

    @Value("${app.code}")
    String code;
    @Override
    public void teachCourse(Course course) {
       // System.out.println(course.getName() + " dersi zoom ile anlatılıyor...");
        instructorService.teach(course.getName(),"Tansu Hnm");
        System.out.println(code+" - " +course.getName() + " dersi zoom ile anlatılıyor...");
    }

    @Override
    public void saveCourse(Course course) {
        repository.save(course);
    }
}
