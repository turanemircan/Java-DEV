package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    // Not: getAll() *********************************
    public List<Student> getAll() {

        return studentRepository.findAll(); // SELECT * FROM student ;
    }
}
