package com.tpe.repository;

import com.tpe.domain.Course;

public class CloudRepository implements Repository{
    @Override
    public void save(Course course) {
        System.out.println(course.getName()+" dersi clouda kaydediliyor...");
    }
}
