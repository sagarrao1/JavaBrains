package com.javabrains.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String errMsg ){
		super(errMsg);
	}
	
	
	
}
