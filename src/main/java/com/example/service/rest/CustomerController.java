package com.example.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@RestController
public class CustomerController {
	    
	    private CustomerRepository customerRepository;
		
		@Autowired
	    public void setProductRepository(CustomerRepository productRepository) {
	        this.customerRepository = productRepository;
	    }
		
	    @RequestMapping("/greeting")
	    public Customer getGreeting(@RequestParam(value="name", defaultValue="World") String name) {
	    	System.out.println("Home Page");
	    	customerRepository.save(new Customer("hamid"));
	    	System.out.println(customerRepository.findAll());
	        return (Customer) new Customer("jack");
	    }
	    
	    @RequestMapping("/getAllCustomers")
	    public Iterable<Customer> getAllCustomers() {
	    	System.out.println("getAllCustomers");
	    	return customerRepository.findAll();
	        
	    }
	    
	    @RequestMapping("/dustring")
	    public String getStringTest(@RequestParam(value="name", defaultValue="World") String name) {
	    	System.out.println("du String");
	        return null;
	    }
}
