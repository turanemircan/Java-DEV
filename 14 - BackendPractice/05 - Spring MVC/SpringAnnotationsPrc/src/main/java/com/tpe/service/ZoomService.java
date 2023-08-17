package com.tpe.service;

import com.tpe.domain.Course;

public class ZoomService implements CourseService{
    @Override
    public void teachCourse(Course course) {
        System.out.println(course.getName()+" dersi zoom ile anlatılıyor...");

    }

    @Override
    public void saveCourse(Course course) {

    }
}
