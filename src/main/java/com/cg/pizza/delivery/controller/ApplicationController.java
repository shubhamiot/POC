package com.cg.pizza.delivery.controller;

import javax.servlet.http.HttpServletRequest;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.pizza.delivery.exception.InvalidInputException;
import com.cg.pizza.delivery.model.Admin;
import com.cg.pizza.delivery.model.Cart;
import com.cg.pizza.delivery.model.Customer;
import com.cg.pizza.delivery.model.Pizza;
import com.cg.pizza.delivery.service.AdminService;
import com.cg.pizza.delivery.service.CartService;
import com.cg.pizza.delivery.service.CustomerService;
import com.cg.pizza.delivery.service.PizzaService;


@Controller
public class ApplicationController {
	
	Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	CustomerService customerService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	CartService cartService;

	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/save-customer")
	public String registerUser(@ModelAttribute Customer customer, BindingResult bindingResult, HttpServletRequest request) {
		customerService.saveMyCustomer(customer);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	@RequestMapping("/delete-customer")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		customerService.deleteMyCustomer(id);
		request.setAttribute("customers", customerService.showAllCustomers());
		request.setAttribute("mode", "ALL_CUSTOMERS");
		return "adminpage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) throws InvalidInputException
	{
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	
	@RequestMapping ("/login-customer")
	
	public String loginUser(@ModelAttribute Customer customer, HttpServletRequest request) {
		Customer c = customerService.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
		if(c!=null)
		{
			logger.trace("Home Page Accessed");
			request.setAttribute("pizzas", pizzaService.listAll());
			request.setAttribute("mode", "AVAILABLE_PIZZAS");
			return "pizzamenu";
		}
		else {
			logger.error("Error Occoured");
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}
	}
	
	  @RequestMapping("/loginadmin") public String loginadmin(HttpServletRequest request) { 
		  request.setAttribute("mode", "MODE_LOGINADMIN"); 
		  return "adminlogin"; 
	   }
	 

	  @RequestMapping("/login-admin") 
	  public String loginadminn(@ModelAttribute Admin admin, HttpServletRequest request) 
	  {
	  if(adminService.findByUsernameAndPassword(admin.getUsername(),admin.getPassword())!=null) 
	  { 
		  return "adminpage";
		  } 
	  else 
	  {
		  request.setAttribute("error", "Invalid Username or Password");
		  request.setAttribute("mode", "MODE_LOGINADMIN");
		  return "adminlogin"; 
	  }
	}
	@RequestMapping("/showcustomers")
	public String showCustomers(@ModelAttribute Customer customer, HttpServletRequest request) {
		 request.setAttribute("customers", customerService.showAllCustomers());
		 request.setAttribute("mode", "ALL_CUSTOMERS" );
	     return "customerpage";
	} 
	@RequestMapping("/addpizza")
	public String addNewPizza(HttpServletRequest request) {
	    request.setAttribute("mode", "ADD_PIZZA");
	    return "createpizza";
    }
	@RequestMapping("/showpizza") 
	public String showPizza(HttpServletRequest request) { 
		request.setAttribute("mode", "ALL_PIZZA" ); 
		request.setAttribute("pizzas", pizzaService.listAll());
		return "editpizza"; }
	
	@PostMapping("/save-pizza")
	public String savePizza(@ModelAttribute Pizza pizza, BindingResult bindingResult, HttpServletRequest request) {
		pizzaService.save(pizza);
		request.setAttribute("mode", "ALL_PIZZA");
		request.setAttribute("pizzas", pizzaService.listAll());
		return "editpizza";
	} 

}
