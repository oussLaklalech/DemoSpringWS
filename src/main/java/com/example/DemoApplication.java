package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@SpringBootApplication
public class DemoApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    

    public CommandLineRunner demo(CustomerRepository repos){
    	
    	return (args) -> {
    		repos.save(new Customer("Jack"));
    		repos.save(new Customer("Chloe"));
    		repos.save(new Customer("David"));
    		repos.save(new Customer("Kim"));
    		
    		// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Customer customer : repos.findAll()) {
				System.out.println(customer.toString());
			}
    	};
    }
    
}
