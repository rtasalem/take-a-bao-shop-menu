package com.rtasalem.menuApi.exception;

public class EventTitleExistsException extends RuntimeException {

	private static final long serialVersionUID = -9060803266928086627L;

	public EventTitleExistsException(String message) {
		super(message);
	}

}
