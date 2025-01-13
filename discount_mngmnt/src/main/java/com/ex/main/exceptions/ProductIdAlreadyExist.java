package com.ex.main.exceptions;

public class ProductIdAlreadyExist extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductIdAlreadyExist() {
	}
	public ProductIdAlreadyExist(String msg) {
		super(msg);
	}

}
