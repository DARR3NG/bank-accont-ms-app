package com.elkastali.accountservice;

import com.elkastali.accountservice.clients.CustomerRestClient;
import com.elkastali.accountservice.entities.BankAccount;
import com.elkastali.accountservice.enums.AccountType;
import com.elkastali.accountservice.repository.BankAcoountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAcoountRepository bankAcoountRepository, CustomerRestClient customerRestClient){
		return  args -> {
			customerRestClient.allCutomers().forEach(c -> {

				BankAccount bankAccount1=BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*800000)
						.createAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();

				BankAccount bankAccount2=BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*800000)
						.createAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();
				bankAcoountRepository.save(bankAccount1);
				bankAcoountRepository.save(bankAccount2);
			} );






		};
	}
}
