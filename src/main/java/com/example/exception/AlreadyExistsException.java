package com.example.exception;

@SuppressWarnings("serial")
public class AlreadyExistsException extends Exception {

	public AlreadyExistsException(String message) {
		super(message);
	}
}
