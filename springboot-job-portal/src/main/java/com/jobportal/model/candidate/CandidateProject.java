package com.jobportal.model.candidate;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class CandidateProject {
	
	@Id
	private Long id;
	private String title;
	private String client;
	private Boolean projectStatus;  //Completed or InProgress / true or false
	private Date fromDate;
	private Date toDate;
	private Boolean isPresentWorking;
	private String projectDetail;

}
