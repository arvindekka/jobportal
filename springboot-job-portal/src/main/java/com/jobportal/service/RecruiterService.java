package com.jobportal.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.Recruiter;
import com.jobportal.model.UserCredential;
import com.jobportal.repository.RecruiterRepo;

@Service
public class RecruiterService {
	
	@Autowired
	RecruiterRepo recruiterRepo;

	Logger logger = LoggerFactory.getLogger(RecruiterService.class);
	
	public Optional<Recruiter> getRecruiterById(Long id) {
		
		return recruiterRepo.findById(id);
	}
	
	public List<Recruiter> getRecruiterAll() {
		
		return (List<Recruiter>) recruiterRepo.findAll();
	}
	
	
	public Optional<Recruiter> authenticate(UserCredential userCredential) {
		
		return recruiterRepo.authenticate(userCredential.getUserId(), userCredential.getPassword());	
	}
	
	public void registerRecruiter(Recruiter c) {
		
//		Candidate c1 = new Candidate();
//		c1.setEmail("email");
//		c1.setName("arv");
		UUID uuid = UUID.randomUUID();
		c.setStatus(uuid.toString());
		recruiterRepo.save(c);
	}

	public Optional<Recruiter> getRecruiterByEmail(String email) {
		
		return recruiterRepo.getRecruiterByEmail(email);
	}

	public Optional<Recruiter> getRecruiterRepoByUUIDStatus(String uuid) {

		return recruiterRepo.getRecruiterByUUIDStatus(uuid);
	}

	public Optional<Recruiter> getProfile(String id) {
		
		return recruiterRepo.findById(Long.parseLong(id));
	}

	public void saveProfile(Recruiter profile) {
		recruiterRepo.save(profile);
	}
	
}
