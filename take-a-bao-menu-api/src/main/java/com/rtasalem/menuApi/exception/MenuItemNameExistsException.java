package com.rtasalem.menuApi.exception;

public class MenuItemNameExistsException extends RuntimeException {

	private static final long serialVersionUID = -1929027302304264463L;

	public MenuItemNameExistsException(String message) {
		super(message);
	}

}
