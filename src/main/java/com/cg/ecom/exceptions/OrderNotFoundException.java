package com.cg.ecom.exceptions;

public class OrderNotFoundException extends RuntimeException
{
	public OrderNotFoundException() {
		super();
		
	}

	public OrderNotFoundException(String message) {
		super(message);
		
	}
}
