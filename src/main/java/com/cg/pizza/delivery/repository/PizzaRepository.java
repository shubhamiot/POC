package com.cg.pizza.delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.delivery.model.Pizza;
 
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	
}
 