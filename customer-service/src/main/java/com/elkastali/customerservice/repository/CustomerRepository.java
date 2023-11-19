package com.elkastali.customerservice.repository;

import com.elkastali.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
