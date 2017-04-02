package com.deyi.springboot.exception;

public class BussineException extends Exception{
	
	private String errorMsg;

	public BussineException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
	
	
}
