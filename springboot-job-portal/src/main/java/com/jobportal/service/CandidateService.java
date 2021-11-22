package com.jobportal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.UserCredential;
import com.jobportal.model.candidate.Candidate;
import com.jobportal.model.candidate.CandidateProfile;
import com.jobportal.repository.CandidateProfileRepo;
import com.jobportal.repository.CandidateRepo;

@Service
public class CandidateService {
	
	
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@Autowired
	CandidateProfileRepo candidateProfileRepo;

	Logger logger = LoggerFactory.getLogger(CandidateService.class);
	
	public static Map<Long,UUID> activationPendingMap = new HashMap<Long,UUID>();
	
	public Optional<Candidate> getCandidateById(Long id) {
		
		return candidateRepo.findById(id);
	}
	
	public List<Candidate> getCandidateAll() {
		
		return (List<Candidate>) candidateRepo.findAll();
	}
	
	
	public Optional<Candidate> authenticate(UserCredential userCredential) {
		
		return candidateRepo.authenticate(userCredential.getUserId(), userCredential.getPassword());	
	}
	
	public void registerCandidate(Candidate c) {
		
//		Candidate c1 = new Candidate();
//		c1.setEmail("email");
//		c1.setName("arv");
		UUID uuid = UUID.randomUUID();
		c.setStatus(uuid.toString());
		candidateRepo.save(c);
	}

	public Optional<Candidate> getCandidateByEmail(String email) {
		
		return candidateRepo.getCandidateByEmail(email);
	}

	public Optional<Candidate> getCandidateByUUIDStatus(String uuid) {

		return candidateRepo.getCandidateByUUIDStatus(uuid);
		
	}

	public Optional<CandidateProfile> getProfile(Long id) {
		
		return candidateProfileRepo.findById(id);
	}

	public void saveProfile(CandidateProfile profile) {
		candidateProfileRepo.save(profile);
	}
	
}
