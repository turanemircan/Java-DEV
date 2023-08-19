package com.tpe.controller;


import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")//http://localhost:8080/SpringMvc/students
//class level:classtaki tüm metodlar için geçerli
//metod level:sadece o metod için geçerli
public class StudentController {

    @Autowired
    private StudentService service;

    //controllerdan mav(veri+view dosyasının ismi) veya String olarak view name i dönebiliriz.

   // @RequestMapping("/students/hi")
    @GetMapping("/hi")//http://localhost:8080/SpringMvc/students/hi + GET
    public ModelAndView sayHi(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Hi; ");
        mav.addObject("messagebody","I am a Student Management System");
        mav.setViewName("hi");
        return mav;
    }
    //view resolver:hi.jsp dosyasını views klasöründe bulur
    // ve mav içindeki datayı bind eder.


    @GetMapping("/new") //http://localhost:8080/SpringMvc/students/new + GET
    public String sendStudentForm(@ModelAttribute("student") Student student){
        return "studentForm";
      }
    //@ModelAttribute studentFormdaki "student" modelının controllera aktarılmasını sağlar.




    //save/create student:response olarak tüm studentları gösterelim
    //http://localhost:8080/SpringMvc/students/saveStudent + POST
    @PostMapping("/saveStudent")
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult){
        //validasyon hatası varsa formu göster
        if (bindingResult.hasErrors()){
            return "studentForm";
        }
        //validasyon hatası yoksa
        service.saveStudent(student);

        return "redirect:/students";//http://localhost:8080/SpringMvc/students/ tekrar bu linke yönlendirir
    }




    //tüm studentları listeleme
    //http://localhost:8080/SpringMvc/students/ + GET
    @GetMapping
    public ModelAndView getStudents(){
        List<Student> allStudent =service.getAllStudent();

        ModelAndView mav=new ModelAndView();
        mav.addObject("studentList",allStudent);
        mav.setViewName("students");
        return mav;
    }

    //update
    //http://localhost:8080/SpringMvc/students/update?id=1 + GET
    @GetMapping("/update")
    public ModelAndView showStudentForm(@RequestParam("id") Long id){
        Student foundStudent=service.findStudentById(id);
        ModelAndView mav=new ModelAndView();
        mav.addObject("student",foundStudent);
        mav.setViewName("studentForm");
        return mav;
    }

    //@RequestParam: Bu anotasyon, bir metodun çağrılması
    // sırasında istek ile gönderilen bir query parametreyi almasını sağlar.


    //delete:tüm studentları gösterelim.
    //http://localhost:8080/SpringMvc/students/delete/1 + GET
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){

        service.deleteStudent(id);

        return "redirect:/students";

    }
    //@PathVariable: request içindeki path parametresinin değerini metodun parametresi olarak
    //almamızı sağlar


    //@ExceptionHandler:try-catchin catch bloğu gibi çalışır
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleNotFoundException(Exception ex){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message",ex.getMessage());
        mav.setViewName("notFound");
        return mav;
    }










}
