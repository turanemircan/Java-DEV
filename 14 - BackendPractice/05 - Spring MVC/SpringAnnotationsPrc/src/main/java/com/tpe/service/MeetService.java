package com.tpe.service;

import com.tpe.domain.Course;

public class MeetService implements CourseService{
    @Override
    public void teachCourse(Course course) {
        System.out.println(course.getName()+" dersi google meet ile anlatılıyor...");
    }

    @Override
    public void saveCourse(Course course) {

    }
}
