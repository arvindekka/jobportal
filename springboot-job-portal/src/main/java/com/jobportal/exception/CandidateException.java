package com.jobportal.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CandidateException {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@ExceptionHandler(CandidateAuthenticatedFailureException.class)
	@ResponseStatus(reason = "User Credentials are not correct.", code = HttpStatus.FORBIDDEN)
	public void handleAuthenticatedFailureException(CandidateAuthenticatedFailureException e) {
		logger.error("User Credentials are not correct");
		logger.error(e.toString());
	}
}
