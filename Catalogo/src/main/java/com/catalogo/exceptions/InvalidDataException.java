package com.catalogo.exceptions;
public class InvalidDataException extends Exception {
	private static final long serialVersionUID = 1L;
	private final static String MESSAGE_STRING = "Invalid data";
	
	public InvalidDataException() {
		this(MESSAGE_STRING);
	}

	public InvalidDataException(String message) {
		super(message);
	}

}
