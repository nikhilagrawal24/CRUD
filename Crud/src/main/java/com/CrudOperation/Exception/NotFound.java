package com.CrudOperation.Exception;

public class NotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotFound(String msg) {
		super(msg);		
	}

}
