package com.wissen.wcart.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ProductNotfoundException.class) 
	public ResponseEntity<Object> handleProductNotfoundException(ProductNotfoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(value = Exception.class) 
	public ResponseEntity<Object> handleAllException(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
	        ex.getBindingResult().toString());
	    return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	  }
	
	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<Object>
	 * handleValidationExceptions(MethodArgumentNotValidException ex) { return new
	 * ResponseEntity<>("Validation error ", HttpStatus.BAD_REQUEST); }
	 */
	
	


	// Similarly we need to implement for Customer and User
	/*
	 * @ExceptionHandler(value = ProductNotfoundException.class) public String
	 * exception(ProductNotfoundException exception) { return
	 * exception.getMessage(); }
	 */
}
