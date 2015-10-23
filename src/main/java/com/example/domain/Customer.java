package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String name;

    public Customer(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	 @Override
	 public String toString() {
	        return "Person [id=" + id + ", name=" + name + "]";
	    }
    
}
