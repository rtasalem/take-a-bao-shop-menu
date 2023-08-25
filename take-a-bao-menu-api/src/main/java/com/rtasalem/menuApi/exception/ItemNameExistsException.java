package com.rtasalem.menuApi.exception;

public class ItemNameExistsException extends RuntimeException {

	private static final long serialVersionUID = -1929027302304264463L;

	public ItemNameExistsException(String message) {
		super(message);
	}

}
