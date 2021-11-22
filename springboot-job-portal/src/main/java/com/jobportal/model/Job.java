package com.jobportal.model;

import java.sql.Date;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String designation;
	private String hiringCompanyName;
	private Double minSalaryPerYear;
	private Double maxSalaryPerYear;
	private Currency currency;
	private Date jobPostingDate;
	private String jobStatus;
	private String jobDescription;
	
	@ManyToOne
    @JoinColumn(name = "recruiterId", nullable = false)
	private Recruiter recruiter;
}
