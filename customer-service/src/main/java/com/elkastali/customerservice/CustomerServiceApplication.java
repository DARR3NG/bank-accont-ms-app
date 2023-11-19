package com.elkastali.customerservice;

import com.elkastali.customerservice.config.GlobalConfig;
import com.elkastali.customerservice.entities.Customer;
import com.elkastali.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer>customers=List.of(
					Customer.builder()
						.firstName("OTMANE")
						.lastName("ELKASTALI")
						.email("elkastaliotmane@gmail.com")
						.build(),
					Customer.builder()
							.firstName("Mohamed")
							.lastName("ELHENAWI")
							.email("elkastaliotmane@gmail.com")
							.build()

			);

			customerRepository.saveAll(customers);
		};
	}
}
