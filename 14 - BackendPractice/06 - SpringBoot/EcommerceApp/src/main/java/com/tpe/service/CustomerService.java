package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.dto.CustomerDTO;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//  5-CustomerService Class
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    //13-b-customer creation
    public void saveCustomer(Customer customer) {

        boolean isExists=customerRepository.existsByEmail(customer.getEmail());
        if (isExists){
            //13-d-custom exception tanımla
            throw new ConflictException("Customer already exists by email : "+customer.getEmail() );
        }

        customerRepository.save(customer);
    }

    //14-b
    public List<Customer> getAll() {
        return  customerRepository.findAll();//SELECT * FROM
    }

    //15-c)getCustomerById
    public Customer getCustomerById(Long id){
        Customer customer=customerRepository.findById(id).//SELECT * FROM .. WHERE id=..
                orElseThrow(()->new ResourceNotFoundException("Customer is not found by id : "+id));
        return customer;
    }

    //15-d)getCustomerDtoById
    public CustomerDTO getCustomerDtoById(Long id) {
           Customer customer=getCustomerById(id);
           CustomerDTO customerDTO=new CustomerDTO(customer);
           return customerDTO;
    }

    //16-b)
    public void deleteCustomerById(Long id) {
        Customer customer=getCustomerById(id);
        customerRepository.delete(customer);
       // customerRepository.deleteById(id);
    }

    //20-b
    public void updateCustomerById(Long id, CustomerDTO customerDto) {//email:aaa@bbbb.com

        Customer customer=getCustomerById(id);
        //email tabloda var mı
        boolean isExists=customerRepository.existsByEmail(customerDto.getEmail());

        if (isExists && !customerDto.getEmail().equals(customer.getEmail())){
            throw new ConflictException("Email already exists in use :"+customerDto.getEmail());
        }

        customer.setName(customerDto.getName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customer.getEmail());//tabloda başka bir customerın emaili:aaa@bbbb.com
        customerRepository.save(customer);
    }

    //21-b
    public Page<Customer> getAllCustomerByPage(Pageable pageable){

        return customerRepository.findAll(pageable);

    }

     //22-b
    public List<Customer> getCustomersByName(String name) {

        return  customerRepository.findByName(name); //select * from Customer where name="name"
    }
}
