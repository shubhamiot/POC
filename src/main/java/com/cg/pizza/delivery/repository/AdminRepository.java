package com.cg.pizza.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.delivery.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByUsernameAndPassword(String username, String password);

}
