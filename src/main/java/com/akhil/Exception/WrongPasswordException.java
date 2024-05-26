package com.akhil.Exception;

public class WrongPasswordException extends RuntimeException{
	public WrongPasswordException(String message) {
		super(message);
	}
}
