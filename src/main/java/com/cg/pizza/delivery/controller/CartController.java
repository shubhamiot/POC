package com.cg.pizza.delivery.controller;

import java.util.List; 

import javax.servlet.http.HttpServletRequest; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.pizza.delivery.model.Cart;
import com.cg.pizza.delivery.service.CartService;
import com.cg.pizza.delivery.service.CustomerService;
import com.cg.pizza.delivery.service.PizzaService;

@Controller
public class CartController {
	
	@Autowired
	 CartService cartService;
	
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	CustomerService customerService;

	
	@RequestMapping("/savetocart")
	public String additems(@ModelAttribute Cart cart,HttpServletRequest request)
	{
		cartService.saveitem(cart);
		request.setAttribute("mode", "ALL_ITEMS");
		request.setAttribute("items", cartService.listAll());
		return "cart";
	}
	
	@RequestMapping("/cartitems")
	public String additems(@ModelAttribute Cart cart,@RequestParam Long id, HttpServletRequest request)
	{
		request.setAttribute("pizza",pizzaService.get(id));
		request.setAttribute("mode","MODE_PREVIEW");
		return "ipreview";
	}
	
	
	  @RequestMapping("/viewcart") 
	  public String viewcart(@ModelAttribute Cart cart, HttpServletRequest request){ 
		  request.setAttribute("mode","ALL_ITEMS"); 
		  request.setAttribute("items", cartService.listAll()); 
		  return "cart";
	  }
	 
	@RequestMapping("/buyitems")
	public String sumofprice(@ModelAttribute Cart cart, HttpServletRequest request)
	{

		cartService.getPrice();
		List<Object[]> pricelist=cartService.getPrice();
		request.setAttribute("mode", "ALL_ITEMS");
		request.setAttribute("items", cartService.listAll());
		request.setAttribute("price", pricelist);
		return "sumprice";
	}
	
	@RequestMapping("/deleteitemfromcart")
	public String deleteitem(@RequestParam int id, HttpServletRequest request)
	{
		cartService.deleteitem(id);
		request.setAttribute("items", cartService.listAll());
		request.setAttribute("mode", "ALL_ITEMS");
		return "cart";
	}
	
	@RequestMapping("/deleteall")
	public String deleteall(@ModelAttribute Cart cart,@RequestParam int id, HttpServletRequest request)
	{
		cartService.deleteitem(id);
		request.setAttribute("mode", "MODE_THANKYOU");
		return "thankyou";
		
	}
//	@RequestMapping("/vieww")
//	public String viewcarts(@ModelAttribute Cart cart, HttpServletRequest request)
//	{
//		request.setAttribute("mode", "ALL_ITEMS");
//		request.setAttribute("items", cartService.listAll());
//		return "cart";
//		
//	}
	@RequestMapping("/gotohome")
	public String deleteall(HttpServletRequest request)
	{
		request.setAttribute("products", pizzaService.listAll());
		request.setAttribute("mode", "ALL_PRODUCTS");
		return "homepage";
	}
}
