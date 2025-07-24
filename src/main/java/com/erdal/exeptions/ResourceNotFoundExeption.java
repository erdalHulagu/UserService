package com.erdal.exeptions;

public class ResourceNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Long id;

	public ResourceNotFoundExeption(String message) {
		super(message);
	}

	public ResourceNotFoundExeption(String message, Long id) {
		super(message);
		this.id = id;

	}
}