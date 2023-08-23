package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
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

    // Not: createStudent()************************************
    public void createStudent(Student student) {

        // !!! email conflict kontrolu
        if(studentRepository.existsByEmail(student.getEmail())){
             throw new ConflictException("Email is already exist!");
        }
        studentRepository.save(student);
    }

    // Not: getByIdWithRequestParam()**********************************************
    public Student findStudent(Long id) {

        return studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student not found with id: "+ id));
    }

    // Not: delete() *********************************************************
    public void deleteStudent(Long id) {

        Student student = findStudent(id);

        studentRepository.delete(student);
        //studentRepository.deleteById(id);

    }
}
