package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import com.tpe.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students") // http://localhost:8080/students
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // Not: getAll() *********************************
    @GetMapping  // http://localhost:8080/students  + GET
    public ResponseEntity<List<Student>> getAll(){

        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students); // 200 + students
        // return new ResponseEntity<>(students, HttpStatus.OK)

    }

    // Not: createStudent()************************************
    @PostMapping // http://localhost:8080/students  + POST + JSON
    public ResponseEntity<Map<String, String>> createStudent(@RequestBody @Valid Student student){

        studentService.createStudent(student);

        Map<String ,String> map = new HashMap<>();
        map.put("message", "Student is created successfully");
        map.put("status", "true");

        return new ResponseEntity<>(map, HttpStatus.CREATED); // map + 201

    }

    // Not: getByIdWithRequestParam()**********************************************
    @GetMapping("/query")// http://localhost:8080/students/query?id=1 + GET
    public ResponseEntity<Student> getStudent(@RequestParam("id") Long id){

        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

    // Not: getByIdWithPath()**********************************************
    @GetMapping("/{id}")       // http://localhost:8080/students/1 + GET
    public ResponseEntity<Student> getStudentWithPath(@PathVariable("id") Long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

    // Not: delete() *********************************************************
    @DeleteMapping("/{id}") // http://localhost:8080/students/1 + DELETE
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){

        studentService.deleteStudent(id);

        String message = "Student is deleted successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    // Not:update()**************************************************************
    @PutMapping("/{id}")  // http://localhost:8080/students/1 + PUT + JSON
    public ResponseEntity<String> updateStudent(@PathVariable Long id,
                                                @RequestBody StudentDTO studentDTO){

        studentService.updateStudent(id, studentDTO);
        String message = "Student is updated successfully";
        return  new ResponseEntity<>(message, HttpStatus.OK);

    }

    // Not: pageable *************************************************************
    @GetMapping("/page") // http://localhost:8080/students/page?page=0&size=10&sort=name&direction=ASC + GET
    public ResponseEntity<Page<Student>> getAllWithPage(
            @RequestParam("page") int page, // kacinci sayfa gelecek
            @RequestParam("size") int size, // her sayfada kac adet urun olsun
            @RequestParam("sort") String prop, // hangi filed a gore siralama yapilacak
            @RequestParam("direction")Sort.Direction direction // dogal siralamami yoksa tersden siralamami yapilacak
            ){

        Pageable pageable = PageRequest.of(page,size, Sort.by(direction, prop));

        Page<Student> studentPage = studentService.getAllWithPage(pageable);

        return ResponseEntity.ok(studentPage);
    }

    // Not: JPQL **********************************************************************
    // 75 puan alan ogrencileri getirelim
    @GetMapping("/grade/{grade}") // http://localhost:8080/students/grade/75 + GET
    public ResponseEntity<List<Student>> getStudentsEqualsGrade(@PathVariable("grade") Integer grade) {

        List<Student> students = studentService.findAllEqualsGrade(grade);

        return ResponseEntity.ok(students);
    }

    // Not: Db den direk DTO olarak verileri alabilir miyim
    @GetMapping("/query/dto") // http://localhost:8080/students/query/dto?id=1 + GET
    public ResponseEntity<StudentDTO> getStudentDTO(@RequestParam("id") Long id){

        StudentDTO studentDTO = studentService.findStudentDtoById(id);

        return ResponseEntity.ok(studentDTO);
    }


}
























