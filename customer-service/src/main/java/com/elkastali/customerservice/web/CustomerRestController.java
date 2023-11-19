package com.elkastali.customerservice.web;


import com.elkastali.customerservice.entities.Customer;
import com.elkastali.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {

    private  CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer>customerList(){
        return customerRepository.findAll();
    }


    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return  customerRepository.findById(id).get();
    }
}
