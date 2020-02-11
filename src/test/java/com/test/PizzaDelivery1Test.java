package com.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.pizza.delivery.model.Customer;
import com.cg.pizza.delivery.repository.CustomerRepository;
import com.cg.pizza.delivery.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class PizzaDelivery1Test {

	@Mock
	CustomerRepository custRepository;;

	@InjectMocks
	private CustomerService customerService;

	@Test
	public void showUsersTest() {
		when(custRepository.findAll()).thenReturn(Stream.of(new Customer("john12", "John", "Geller", 25, "987654321"),
				new Customer("anu", "Anurag", "Tiwari", 24, "Jaya@0901")).collect(Collectors.toList()));
		assertEquals(2, customerService.showAllCustomers().size());
	}

	
	 @SuppressWarnings("unchecked")
	 
	 @Test public void getbyunameandpwd() 
	 {
		 String username="john12";
		 String password="987654321"; 
		 when(custRepository.findByUsernameAndPassword(username,password)).thenReturn((Customer) Stream.of(new Customer("john12","John","Geller",25,"987654321")).collect(Collectors.toList()));
	 assertEquals(1, ((List<Customer>) customerService.findByUsernameAndPassword(username,password)).size()); 
	 }
	 

	@Test
	public void saveUserTest() {
		Customer customer = new Customer("satya", "satyam", "Singh", 34, "Ramya");
		when(custRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.saveMyCustomer(customer));
	}
}
