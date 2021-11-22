package com.jobportal.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserCredential {
	
	private Long userId;
	private String password;

}