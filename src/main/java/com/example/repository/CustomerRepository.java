package com.example.repository;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Customer;

@Service
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByName(String name);
}
