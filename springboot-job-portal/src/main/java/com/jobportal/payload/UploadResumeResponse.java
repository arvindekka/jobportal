package com.jobportal.payload;

public class UploadResumeResponse {
	
	private String message;
	private String status;
	
	public UploadResumeResponse(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public UploadResumeResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
