package com.jobportal.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.exception.CandidateAuthenticatedFailureException;
import com.jobportal.model.Recruiter;
import com.jobportal.model.UserCredential;
import com.jobportal.model.candidate.Candidate;
import com.jobportal.repository.CandidateRepo;
import com.jobportal.repository.RecruiterRepo;
import com.jobportal.service.CandidateService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@Autowired
	RecruiterRepo recruiterRepo;
	
	@Autowired
	CandidateService candidateService;

	@PostMapping("/authenticateCandidate")
	public Candidate authenticateCandidate(@RequestBody UserCredential userCredential) throws InterruptedException {
		
		Thread.sleep(1000);
		
		Optional<Candidate> candidate = candidateRepo.authenticate(userCredential.getUserId(), userCredential.getPassword());
		
		if(!candidate.isPresent()) {
			throw new CandidateAuthenticatedFailureException("");
		}
		Candidate candidate2 = candidate.get();
		candidate2.setLoggedIn(true);
		return candidate2;
	}
	
	@GetMapping("/logoutCandidate")
	public Candidate logoutCandidate(@RequestParam Long id) {
		candidateRepo.logout(id);
		Optional<Candidate> candidate = candidateService.getCandidateById(id);
		return candidate.get();
	}
	
	
	@GetMapping("/logoutRecruiter")
	public Recruiter logoutRecruiter(@RequestParam Long id) {
		recruiterRepo.logout(id);
		Optional<Recruiter> recruiter = recruiterRepo.findById(id);
		return recruiter.get();
	}
	
	
	@GetMapping("/jobportal/activationCandidate")
	public String activationCandidate(@RequestParam UUID uuid) {
		Optional<Candidate> candidateDb = candidateService.getCandidateByUUIDStatus(uuid.toString());
		
		if(candidateDb.isPresent()) {
			//Update the status of candidate to active
			Candidate c = candidateDb.get();
			c.setStatus("ACTIVE");
			candidateRepo.save(c);
			return "Account is activated, Redirecting to JobPortal. Thank you.";
		}
		else {
			return "Invalid activation. Please try re-registration. Thank you.";
		}
	}
	
	
	@PostMapping("/authenticateRecruiter")
	public Recruiter authenticateRecruiter(@RequestBody UserCredential userCredential) throws InterruptedException {
		
		Thread.sleep(1000);
		
		Optional<Recruiter> recruiter = recruiterRepo.authenticate(userCredential.getUserId(), userCredential.getPassword());
		
		if(!recruiter.isPresent()) {
			throw new CandidateAuthenticatedFailureException("");
		}
		Recruiter recruiter2 = recruiter.get();
		recruiter2.setLoggedIn(true);
		return recruiter2;
	}

	
	
	@GetMapping("/jobportal/activationRecruiter")
	public String activationRecruiter(@RequestParam UUID uuid) {
		Optional<Recruiter> RecruiterDb = recruiterRepo.getRecruiterByUUIDStatus(uuid.toString());
		
		if(RecruiterDb.isPresent()) {
			//Update the status of candidate to active
			Recruiter  c = RecruiterDb.get();
			c.setStatus("ACTIVE");
			recruiterRepo.save(c);
			return "Account is activated, Redirecting to JobPortal. Thank you.";
		}
		else {
			return "Invalid activation. Please try re-registration. Thank you.";
		}
	}
	
	 
	
}
