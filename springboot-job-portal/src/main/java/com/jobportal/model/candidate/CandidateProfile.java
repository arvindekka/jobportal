package com.jobportal.model.candidate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class CandidateProfile  {
	@Id
	private Long id;
	private String location;
	private String currentWorkingOrg;
	private Integer yearsOfExp;
	private Double ctc;
	private String role;

}
