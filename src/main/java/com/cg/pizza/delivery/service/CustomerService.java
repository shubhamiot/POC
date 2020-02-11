package com.cg.pizza.delivery.service;
 
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.pizza.delivery.model.Customer;
import com.cg.pizza.delivery.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer saveMyCustomer(Customer customer ) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> showAllCustomers(){
		List<Customer> users = customerRepository.findAll();
		System.out.println("Getting Data from Database:"+ users);
		return users;
	}
	
	public void deleteMyCustomer(int id) {
		  customerRepository.delete(id);
	}
	
	public Customer editCustomer(int id) {
		return customerRepository.findOne(id);
	}
	
	public Customer findByUsernameAndPassword(String username, String password) {
		return customerRepository.findByUsernameAndPassword(username, password);
	}

	public Object findAll(String username, String firstname, String lastname, int age, String password) {
		return customerRepository.findAll();
	}
}

	