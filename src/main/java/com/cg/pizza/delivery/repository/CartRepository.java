package com.cg.pizza.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.pizza.delivery.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	@Query(value="select SUM(c.price * c.quantity) from Cart c")
	 public  List<Object[]> getPrice();
	 
	 @Query(value="delete from Cart c where c.quantity > 0")
	 public void deleteitems();
}
