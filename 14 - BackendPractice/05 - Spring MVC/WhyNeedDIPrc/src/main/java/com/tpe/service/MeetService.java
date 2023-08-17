package com.tpe.service;

import com.tpe.domain.Course;

public class MeetService implements CourseService {

    @Override //opsiyonel, interface ile aynı methoda sahip olduğu için yazılmasa da olur. kod okunabilirliği açısından kullanılır
    public void teachCourse(Course course){
        System.out.println(course.getName()+" dersi google meet ile anlatılıyor...");
    }

    @Override
    public void saveCourse(Course course) {

    }
}
