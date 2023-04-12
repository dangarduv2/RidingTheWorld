package com.catalogo.exceptions;

public class DuplicateKeyException extends Exception {
	private static final long serialVersionUID = 1L;
	private final static String MESSAGE_STRING = "Duplicate key";
	
	public DuplicateKeyException() {
		this(MESSAGE_STRING);
	}

	public DuplicateKeyException(String message) {
		super(message);
	}

}
