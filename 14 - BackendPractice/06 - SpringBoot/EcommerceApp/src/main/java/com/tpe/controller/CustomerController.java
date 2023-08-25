package com.tpe.controller;

//4-CustomerController Class

import com.tpe.domain.Customer;
import com.tpe.dto.CustomerDTO;
import com.tpe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    //14-a)tüm customerlar: http://localhost:8080/customers + GET
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){

        List<Customer> customers  =customerService.getAll();

       // return new ResponseEntity<>(customers,HttpStatus.OK);//200
        return ResponseEntity.ok(customers);//200
    }

    //15-a)id ile customer getirme: http://localhost:8080/customers/1 + GET
    //15-b)DTO tanımlayalım ve geriye döndürelim
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id){
        CustomerDTO customerDto=customerService.getCustomerDtoById(id);
        return ResponseEntity.ok(customerDto);//200
    }

    //ÖDEV: id ile customer getirme: http://localhost:8080/customers/get?id=1 + GET


    //16-a)id ile customer silme http://localhost:8080/customers/custom?id=1 + DELETE
    @DeleteMapping("/custom")
    public ResponseEntity<String> deleteCustomerById(@RequestParam("id") Long id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("Customer is deleted successfully");//200
    }





















}
