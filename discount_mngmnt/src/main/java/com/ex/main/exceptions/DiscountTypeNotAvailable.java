package com.ex.main.exceptions;

public class DiscountTypeNotAvailable extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DiscountTypeNotAvailable() {
	}
	
	public DiscountTypeNotAvailable(String msg) {
		super(msg);
	}
	
	

}
