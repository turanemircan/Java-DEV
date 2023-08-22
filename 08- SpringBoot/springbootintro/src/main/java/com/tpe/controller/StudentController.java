package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students") // http://localhost:8080/students  + GET
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // Not: getAll() *********************************
    @GetMapping  // http://localhost:8080/students  + GET
    public ResponseEntity<List<Student>> getAll(){

        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students); // 200 + students

    }
}
