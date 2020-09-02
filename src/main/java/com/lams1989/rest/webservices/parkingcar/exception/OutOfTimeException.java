package com.lams1989.rest.webservices.parkingcar.exception;

public class OutOfTimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutOfTimeException(String message) {
		super(message);
	}
}
