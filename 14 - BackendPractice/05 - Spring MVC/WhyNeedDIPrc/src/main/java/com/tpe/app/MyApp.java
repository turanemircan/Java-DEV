package com.tpe.app;

import com.tpe.domain.Course;
import com.tpe.repo.CloudRepo;
import com.tpe.repo.LocalRepo;
import com.tpe.repo.Repo;
import com.tpe.service.CourseService;
import com.tpe.service.MeetService;
import com.tpe.service.ZoomService;

public class MyApp {
    public static void main(String[] args) {

        Repo repo = new LocalRepo();
        CourseService service = new ZoomService(repo);

        Course course = new Course();
        course.setName("Fen Bilgisi");

        //Fen bilgisi dersinin zoom ile anlatılması isteniyor
//        ZoomService zoomService=new ZoomService();
//        zoomService.teachCourse(course);

        //Ders google meet ile anlatılmak isterse
//        MeetService meetService=new MeetService();
//        meetService.teachCourse(course);

//        CourseService service=new ZoomService();
//        service.teachCourse(course);
//
//        //dersin buluta kaydedilmesini istiyorum
//        service.saveCourse(course);

        service.teachCourse(course);
        service.saveCourse(course);
    }
}
