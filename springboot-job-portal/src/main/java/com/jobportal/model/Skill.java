package com.jobportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long skillId;
	
	private String category;
	private String subCategory1;
	private String subCategory2;
	private String skillName;
	
	public Skill() {
		
	}
	
	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}

}
