package com.example.bootrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

public class CustomerLoader implements ApplicationListener<ContextRefreshedEvent>{

	private CustomerRepository custumerRepository;
	 
    private Logger log = LoggerFactory.getLogger(CustomerLoader.class);
 
    @Autowired
    public void setProductRepository(CustomerRepository productRepository) {
        this.custumerRepository = productRepository;
    }
    
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Customer shirt = new Customer("jack");
		shirt.setDescription("Spring Framework Guru Shirt");
		custumerRepository.save(shirt);
        
        log.info("Saved Shirt - id: " + shirt.getId());
 
        Customer mug = new Customer("mug");
        mug.setDescription("Spring Framework Guru Mug");
        custumerRepository.save(mug);
        
        log.info("Saved Mug - id:" + mug.getId());
	}

	
}
