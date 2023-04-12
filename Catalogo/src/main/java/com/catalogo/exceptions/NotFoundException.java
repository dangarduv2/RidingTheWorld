package com.catalogo.exceptions;
public class NotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private final static String MESSAGE_STRING = "Not found Object With this ID";
	
	public NotFoundException() {
		this(MESSAGE_STRING);
	}

	public NotFoundException(String message) {
		super(message);
	}
}
