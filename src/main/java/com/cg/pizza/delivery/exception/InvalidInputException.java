package com.cg.pizza.delivery.exception;

public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String msg) {
		super(msg);
	}

}
