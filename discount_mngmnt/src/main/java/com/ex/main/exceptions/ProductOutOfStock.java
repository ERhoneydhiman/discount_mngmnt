package com.ex.main.exceptions;

public class ProductOutOfStock extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductOutOfStock() {
	}

	public ProductOutOfStock(String msg) {
		super(msg);
	}

}
