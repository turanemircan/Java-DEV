package com.tpe.dto;

import com.tpe.domain.Student;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {


    private Long id; // int id : default 0

    @NotNull(message = "first name can not be null")
    @NotBlank(message = "first name can not be white space")
    @Size(min=2,max = 25,message = "First name '${validatedValue}' must be between {min} and {max} long")

    private String firstName; //

    private String lastName;

    private Integer grade;

    @Email(message = "Provide valid email")
    private  String email; // aba@

    private String phoneNumber;

    private LocalDateTime createDate = LocalDateTime.now();

    public StudentDTO(Student student){

        this.id = student.getId();
        this.firstName = student.getName();
        this.lastName = student.getLastName();
        this.grade = student.getGrade();
        this.email = student.getEmail();
        this.phoneNumber = student.getPhoneNumber();
        this.createDate = student.getCreateDate();
    }

}
