package com.elkastali.accountservice.repository;

import com.elkastali.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAcoountRepository extends JpaRepository<BankAccount,String> {

}
