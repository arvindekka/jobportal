package com.jobportal.model.candidate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.jobportal.model.Skill;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class CandidateEducation {

	@Id
	private Long id;
	private String education;
	private String SchoolOrUniveristy;
	private String passingYear;
	private Double passingPercentage;
}
