package com.cg.pizza.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.delivery.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {	
	
	public Customer findByUsernameAndPassword(String username, String password);
}
