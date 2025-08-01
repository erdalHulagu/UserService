package com.erdal.exeptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Long id;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Long id) {
		super(message);
		this.id = id;

	}
}