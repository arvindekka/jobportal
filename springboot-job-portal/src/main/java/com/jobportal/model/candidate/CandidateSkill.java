package com.jobportal.model.candidate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jobportal.model.Skill;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class CandidateSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @OneToMany(targetEntity=Skill.class)  
	private List<Skill> skillList;
}
