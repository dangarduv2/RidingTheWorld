package com.catalogo.exceptions;

public class BadRequestException extends Exception {
	private static final long serialVersionUID = 1L;
    private final static String MESSAGE_STRING = "Duplicate key";
	
	public BadRequestException() {
		this(MESSAGE_STRING);
	}
	public BadRequestException(String message) {
		super(message);
	}

}
