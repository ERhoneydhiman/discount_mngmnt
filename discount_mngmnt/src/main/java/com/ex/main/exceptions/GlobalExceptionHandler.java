package com.ex.main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponce handleValidationException(ValidationException e) {
		return new ErrorResponce(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler(value = ProductOutOfStock.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponce handleProductOutOfStock(ProductOutOfStock e) {
		return new ErrorResponce(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler(value = DiscountTypeNotAvailable.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponce handleDiscountTypeNotAvailable(DiscountTypeNotAvailable e) {
		return new ErrorResponce(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler(value = ProductNotFound.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponce handleProductNotFound(ProductNotFound e) {
		return new ErrorResponce(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler(value = ProductIdAlreadyExist.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponce handleProductAlreadyExist(ProductIdAlreadyExist e) {
		return new ErrorResponce(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

}
