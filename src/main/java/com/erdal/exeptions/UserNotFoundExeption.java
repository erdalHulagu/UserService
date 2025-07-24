package com.erdal.exeptions;

public class UserNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Long id;

	public UserNotFoundExeption(String message) {
		super(message);
	}

	public UserNotFoundExeption(String message, Long id) {
		super(message);
		this.id = id;

	}
}