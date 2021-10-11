package com.wissen.wcart.exception;

public class ProductNotfoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	String message;
	
	public ProductNotfoundException(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
