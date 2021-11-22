package com.jobportal.exception;

public class CandidateAuthenticatedFailureException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CandidateAuthenticatedFailureException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandidateAuthenticatedFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CandidateAuthenticatedFailureException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CandidateAuthenticatedFailureException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CandidateAuthenticatedFailureException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
