package com.rtasalem.menuApi.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6584550896117646185L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
