package com.tpe.service;

import com.tpe.domain.Course;
import com.tpe.repo.LocalRepo;
import com.tpe.repo.Repo;

public class ZoomService implements CourseService {

    private Repo repo;
    public ZoomService(Repo repo) {
        this.repo = repo;
    }

    @Override
    public void teachCourse(Course course) {
        System.out.println(course.getName() + " dersi zoom ile anlatılıyor...");
    }

    @Override
    public void saveCourse(Course course) {
//        Repo repo=new LocalRepo();
        repo.save(course);
    }
}
