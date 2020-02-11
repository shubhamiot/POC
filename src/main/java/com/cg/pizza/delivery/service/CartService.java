package com.cg.pizza.delivery.service;

import java.util.List; 

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.pizza.delivery.model.Cart;
import com.cg.pizza.delivery.repository.CartRepository;


@Service
@Transactional
public class CartService {

	private CartRepository cartRepository;
	public CartService(CartRepository cartRepository)
	{
		this.cartRepository=cartRepository;
	}
	 public Cart saveitem(Cart cart) {
		  return cartRepository.save(cart);
	  }

	public List<Cart> listAll() {
		return cartRepository.findAll();
	}
	
	 public List<Object[]> getPrice() {
        return cartRepository.getPrice();
        }
	 
	public void deleteitem(int id) {
		 cartRepository.delete(id);
	}
	
	public void removecartitems() {
		 cartRepository.deleteitems();	
	}

}
