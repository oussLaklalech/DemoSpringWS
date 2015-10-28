package com.example.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.domain.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByName(String name);
}
