package com.example.exception;

@SuppressWarnings("serial")
public class AccessDeniedException extends Exception {

	public AccessDeniedException(String message) {
		super(message);
	}
}
