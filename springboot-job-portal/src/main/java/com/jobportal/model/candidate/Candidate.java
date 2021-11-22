package com.jobportal.model.candidate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "candidate")
@Data
@ToString
@NoArgsConstructor
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private String status; //Active, PendingActivation, Inactive
	private Boolean loggedIn;

	public Candidate(String name, String email, String password, String status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	
	
}
