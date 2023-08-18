package com.tpe.controller;


import com.tpe.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
//class level:classtaki tüm metodlar için geçerli
//metod level:sadece o metod için geçerli
public class StudentController {

    //controllerdan mav(veri+view dosyasının ismi) veya String olarak view name i dönebiliriz.

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





}
