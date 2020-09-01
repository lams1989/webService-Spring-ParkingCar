package com.lams1989.rest.webservices.parkingcar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException {
	public TicketNotFoundException(String message) {
		super(message);
	}

}
