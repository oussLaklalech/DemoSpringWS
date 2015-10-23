package com.example.service.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@RestController
public class CustomerController {
	    
	    private CustomerRepository repository;

	    @RequestMapping("/greeting")
	    public Customer getGreeting(@RequestParam(value="name", defaultValue="World") String name) {
	    	System.out.println("Home Page");
	        return (Customer) new Customer("jack");
	    }
	    
	    @RequestMapping("/dustring")
	    public String getStringTest(@RequestParam(value="name", defaultValue="World") String name) {
	    	System.out.println("du String");
	        return null;
	    }
}
