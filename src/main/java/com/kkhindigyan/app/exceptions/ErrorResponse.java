package com.kkhindigyan.app.exceptions;

import java.util.List;

public class ErrorResponse {

	// Message about an error
	private String message;

	// About errors in API request processing
	private List<String> details;

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getDetails() {
		return details;
	}
}