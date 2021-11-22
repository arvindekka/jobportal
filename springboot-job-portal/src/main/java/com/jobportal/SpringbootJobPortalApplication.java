package com.jobportal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jobportal.model.Recruiter;
import com.jobportal.model.Skill;
import com.jobportal.model.candidate.Candidate;
import com.jobportal.repository.CandidateRepo;
import com.jobportal.repository.RecruiterRepo;
import com.jobportal.repository.SkillRepo;

@SpringBootApplication
public class SpringbootJobPortalApplication {
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@Autowired
	RecruiterRepo recruiterRepo;
	
	@Autowired
	SkillRepo skillRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJobPortalApplication.class, args);
	}
	
	@PostConstruct
	private void insertingTestData() {
		
		//Clear previous entries
		skillRepo.deleteAll();
		
		//Saving skills
		skillRepo.save(new Skill("Java"));
		skillRepo.save(new Skill("C#"));
		skillRepo.save(new Skill("React"));
		skillRepo.save(new Skill("Vue.js"));
		skillRepo.save(new Skill("Angular"));
		skillRepo.save(new Skill("React Native"));
		skillRepo.save(new Skill("Junit"));
		skillRepo.save(new Skill("Spring Boot"));
		skillRepo.save(new Skill("Spring"));
		skillRepo.save(new Skill("Spring Microservices"));
		skillRepo.save(new Skill("Spring JPA"));
		skillRepo.save(new Skill("Swagger"));
		
		candidateRepo.save(new Candidate("Arvind", "arvind@test.com", "a", "ACTIVE"));
		candidateRepo.save(new Candidate("Rupesh", "rupesh@test.com", "a", "ACTIVE"));
		candidateRepo.save(new Candidate("Kishore", "kishore@test.com", "a", "ACTIVE"));
		candidateRepo.save(new Candidate("Niraj", "niraj@test.com", "a", "ACTIVE"));
		
		recruiterRepo.save(new Recruiter("Govind","a","jitendra@test.com","Talent Hunt", "ACTIVE",false));
		recruiterRepo.save(new Recruiter("Arjun","a","mukesh@test.com","Headsnmind", "ACTIVE",false));
		recruiterRepo.save(new Recruiter("Shalini", "a","Suresh@test.com","TalentMinds","ACTIVE",false));
		
	}
}
