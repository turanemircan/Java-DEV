package com.tpe.controller;

//4-CustomerController Class

import com.tpe.domain.Customer;
import com.tpe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController//rest api için controller
@RequestMapping("/customers")//http://localhost:8080/customers ve http://localhost:8080/customers/...
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    //13-a)customer oluşturma/kaydetme -> http://localhost:8080/customers/save + POST + JSON Body
    //email daha önce kullanılmışsa hata fırlatır.(ConflictException)
    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody Customer customer){

        customerService.saveCustomer(customer);

        return new ResponseEntity<>("Customer is saved successfully", HttpStatus.CREATED);//201
    }
















}
