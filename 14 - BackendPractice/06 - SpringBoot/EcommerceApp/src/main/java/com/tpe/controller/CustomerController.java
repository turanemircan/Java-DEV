package com.tpe.controller;

//4-CustomerController Class

import com.tpe.domain.Customer;
import com.tpe.domain.OrderItem;
import com.tpe.dto.CustomerDTO;
import com.tpe.dto.OrderDTO;
import com.tpe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

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

    //20-a)id ile customer ı update etme -> http://localhost:8080/customers/update/1 + PUT + JSON Body
    ////Customer is updated successfully mesajı dönsün.
    ////emaili update ederken yeni değer tabloda var ve kendi maili değilse hata fırlatır. (ConflictException)

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") Long id,@RequestBody CustomerDTO customerDto ){

        customerService.updateCustomerById(id,customerDto);

        return ResponseEntity.ok("Customer is updated successfully");//200
    }


    //21-a)tüm customerları page page gösterme ->
    // http://localhost:8080/customers/page?sayfa=1
    //                                      &size=2
    //                                      &sort=id
    //                                      &direction=ASC  + GET
    @GetMapping("/page")
    public ResponseEntity<Page<Customer>> getAllByPage(@RequestParam("sayfa") int page,
                                                       @RequestParam("size")  int size,
                                                       @RequestParam("sort") String prop,
                                                       @RequestParam("direction") Sort.Direction direction){

        Pageable pageable= PageRequest.of(page,size,Sort.by(direction,prop));
        Page<Customer>  customers=customerService.getAllCustomerByPage(pageable);
        return ResponseEntity.ok(customers);//200
    }

    //22-Name ile customer getirme -> http://localhost:8080/customers/query?name=Jack + GET
    @GetMapping("/query")
    public ResponseEntity<List<Customer>> getAllCustomerByName(@RequestParam("name") String name){

        List<Customer> customersByName=customerService.getCustomersByName(name);

        return ResponseEntity.ok(customersByName);

    }

    //23-fullname ile customer getirme-> http://localhost:8080/customers/fullquery?
    //name=Jack&lastName=Sparrow
    @GetMapping("/fullquery")
    public ResponseEntity<List<Customer>> getAllCustomerByFullName(@RequestParam("name") String name,
                                                                   @RequestParam("lastName") String lastName){
        List<Customer> customers=customerService.getAllCustomerByFullName(name,lastName);
        return ResponseEntity.ok(customers);
    }



    //24-a-İsmi ... içeren customerlar -> http://localhost:8080/customers/jpql?name=Ja (JPQL)
    @GetMapping("/jpql")
    public ResponseEntity<List<Customer>> getAllCustomerByNameLike(@RequestParam("name") String word){

        List<Customer> customerList=customerService.getAllCustomerByNameLike(word);
        return ResponseEntity.ok(customerList);
    }


    //25-Idsi verilen müşterinin tüm siparişlerini getirme -> http://localhost:8080/customers/allorder/1
    //25-b: OrderDTO
    @GetMapping("/allorder/{id}")
    public ResponseEntity<Set<OrderDTO>> getAllOrderByCustomer(@PathVariable Long id){

     // Set<OrderItem> orders=customerService.getCustomerById(id).getOrders();

        Set<OrderDTO> orderDTOS=customerService.getAllOrderOfCustomer(id);

        return ResponseEntity.ok(orderDTOS);
    }





    //ÖDEV-Requestle gelen "harf dizisi" name veya lastname inde geçen customerları döndür. (JPQL)
    //-> http://localhost:8080/customers/search?word=pa



















}
