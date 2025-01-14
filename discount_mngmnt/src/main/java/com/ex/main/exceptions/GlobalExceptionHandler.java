package com.ex.main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponce handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ErrorResponce(HttpStatus.BAD_REQUEST.value(), "Invalid input format. Please check the data types in your request.");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponce handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new ErrorResponce(HttpStatus.BAD_REQUEST.value(), "Invalid type for parameter: " + e.getName() + ". Expected type: " + e.getRequiredType().getSimpleName());
    }
}
