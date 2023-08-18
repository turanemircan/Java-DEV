package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {


        //configurasyon yapısını bildirmek için context oluşturalım
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        //Course objesi üretelim
        Course course = new Course();
        course.setName("Matematik");

        //courseService ten context le bean üretelim
        CourseService service = context.getBean("zoomService", CourseService.class);

        service.teachCourse(course);
        service.saveCourse(course);

        //Kullandığımız bean leri görmek istersek
        System.out.println("--------------------------------");
        String [] beanNames = context.getBeanDefinitionNames();

        for(String name:beanNames){
            System.out.println("Bean name : "+name);
        }

        CourseService service1 = context.getBean("zoomService", CourseService.class);
    }

}
