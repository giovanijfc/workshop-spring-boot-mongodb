package com.giovanijfc.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -6379355199782897760L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
}
