package com.jobportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String password;
	private String email;
	private String companyName;
	private String status; //Active, PendingActivation, Inactive
	private Boolean loggedIn;
	
	public Recruiter() {
		
	}

	public Recruiter(String name, String password, String email, String companyName, String status, Boolean loggedIn) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.companyName = companyName;
		this.status = status;
		this.loggedIn = loggedIn;
	}

	
	
	
	

}
