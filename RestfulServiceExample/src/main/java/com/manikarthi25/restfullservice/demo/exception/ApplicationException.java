package com.manikarthi25.restfullservice.demo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		String errorDescription = ex.getLocalizedMessage();
		if (errorDescription == null)
			errorDescription = ex.toString();

		return getException(errorDescription);

	}

	@ExceptionHandler(value = { NullPointerException.class, UserdefinedException.class })
	public ResponseEntity<Object> handleSpecifException(Exception ex, WebRequest request) {

		String errorDescription = ex.getLocalizedMessage();
		if (errorDescription == null)
			errorDescription = ex.toString();
		return getException(errorDescription);
	}

	private ResponseEntity<Object> getException(String errorDescription) {
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
