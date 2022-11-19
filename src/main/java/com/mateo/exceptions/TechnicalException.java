package com.mateo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class TechnicalException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6104231215502727550L;

	public TechnicalException(String message) {
        super(message);
    }
}
