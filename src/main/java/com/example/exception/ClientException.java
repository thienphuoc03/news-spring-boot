package com.example.exception;

@SuppressWarnings("serial")
public class ClientException extends Exception {
	public ClientException(String message) {
		super(message);
	}
}
