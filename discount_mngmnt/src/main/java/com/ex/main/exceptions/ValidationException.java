package com.ex.main.exceptions;

public class ValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException() {
	}
	public ValidationException(String msg) {
		super(msg);
	}

}
