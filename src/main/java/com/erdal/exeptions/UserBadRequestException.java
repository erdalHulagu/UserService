package com.erdal.exeptions;

public class UserBadRequestException extends RuntimeException {



	private static final long serialVersionUID = 1L;

	private Long id;

	public UserBadRequestException(String message) {
		super(message);
	}

	public UserBadRequestException(String message, Long id) {
		super(message);
		this.id = id;

	}
}