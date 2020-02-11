package com.cg.pizza.delivery.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pizza")
public class Pizza {
	private Long id;
	private String name;
	private String topping;
	private String crust;
	private int price;

	public Pizza() {
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopping() {
		return topping;
	}


	public void setTopping(String topping) {
		this.topping = topping;
	}


	public String getCrust() {
		return crust;
	}


	public void setCrust(String crust) {
		this.crust = crust;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pizza(Long id, String name, String topping, String crust, int price) {
		super();
		this.id = id;
		this.name = name;
		this.topping = topping;
		this.crust = crust;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", topping=" + topping + ", crust=" + crust + ", price=" + price
				+ "]";
	}
	
	
}