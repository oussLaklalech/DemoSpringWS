package com.example;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import config.RepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class CustomerRepositoryTest {

	private CustomerRepository customerRepository;
	
	@Autowired
    public void setProductRepository(CustomerRepository productRepository) {
        this.customerRepository = productRepository;
    }
	
	@Test
    public void testSaveProduct(){
        //setup product
        Customer product = new Customer("ouss");
        product.setDescription("my descrption of ouss");
 
        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        customerRepository.save(product);
        assertNotNull(product.getId()); //not null after save
 
        //fetch from DB
        Customer fetchedProduct = customerRepository.findOne(product.getId());
 
        //should not be null
        assertNotNull(fetchedProduct);
 
        //should equal
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());
 
        //update description and save
        fetchedProduct.setDescription("New Description");
        customerRepository.save(fetchedProduct);
 
        //get from DB, should be updated
        Customer fetchedUpdatedProduct = customerRepository.findOne(fetchedProduct.getId());
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());
 
        //verify count of products in DB
        long productCount = customerRepository.count();
        assertEquals(productCount, 1);
 
        //get all products, list should only have one
        Iterable<Customer> products = customerRepository.findAll();
 
        int count = 0;
 
        for(Customer p : products){
            count++;
        }
 
        assertEquals(count, 1);
    }
}
