package com.assignment.salesorder.exception;

public class CustomerException extends Exception{

	
	public static final long serialVersionUID = 1L;
	public String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public CustomerException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	
	public CustomerException() {
		super();
	}
	
	/*
	 * public void setErrorMessage(String errorMessage) { this.errorMessage =
	 * errorMessage; }
	 */
}
