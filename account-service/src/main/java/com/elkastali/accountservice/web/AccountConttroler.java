package com.elkastali.accountservice.web;


import com.elkastali.accountservice.clients.CustomerRestClient;
import com.elkastali.accountservice.entities.BankAccount;
import com.elkastali.accountservice.model.Customer;
import com.elkastali.accountservice.repository.BankAcoountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountConttroler {


    private BankAcoountRepository bankAcoountRepository;
    private CustomerRestClient customerRestClient;


    @GetMapping("/accounts")
    public List<BankAccount> accountList(){

        List<BankAccount> accountList=bankAcoountRepository.findAll();
        accountList.forEach(acc -> {
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });

        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAcountById(@PathVariable  String id){
        BankAccount bankAccount = bankAcoountRepository.findById(id).get();

        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);


        return bankAccount;
    }
}
