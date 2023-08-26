package com.tpe.repository;

import com.tpe.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//     6-CustomerRepository interface
@Repository//optional
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    //13-c
    boolean existsByEmail(String email);

    List<Customer> findByName(String name);//select * from Customer where name="name"
}
