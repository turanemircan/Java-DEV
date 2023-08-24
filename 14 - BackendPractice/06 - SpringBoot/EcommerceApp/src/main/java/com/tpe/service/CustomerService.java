package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//  5-CustomerService Class
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    //13-b-customer creation
    public void saveCustomer(Customer customer) {

        boolean isExists=customerRepository.existsByEmail(customer.getEmail());
        if (isExists){
            //TODO:exception fırlatılacak...
        }

        customerRepository.save(customer);
    }
}
