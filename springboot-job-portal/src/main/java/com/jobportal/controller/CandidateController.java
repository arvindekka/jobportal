package com.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.model.candidate.Candidate;
import com.jobportal.model.candidate.CandidateProfile;
import com.jobportal.notification.Mailer;
import com.jobportal.service.CandidateService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CandidateController {
	
	@Autowired
	CandidateService candidateService;
	
	
	@Autowired
	Mailer mailer;
	
	@Autowired
	Environment env;
	
	private static Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	@RequestMapping("/candidate/{id}")
	public Optional<Candidate> getCandidateDetails(@PathVariable Long id) {
		System.out.println(id);
		return candidateService.getCandidateById(id);
	}
	
	@RequestMapping("/candidateProfile/{id}")
	public Optional<CandidateProfile> getCandidateProfile(@PathVariable Long id) {
		System.out.println(id);
		return candidateService.getProfile(id);
	}
	
	@GetMapping("/candidates")
	public  List<Candidate> getCandidateAll() {
		return candidateService.getCandidateAll();
	}
	
	@PostMapping("/candidate/create")
	public  ResponseEntity<String> registerCandidate(@RequestBody Candidate candidate) {

//		System.out.println(candidate);
		candidateService.registerCandidate(candidate);
		Optional<Candidate> candidateDb = candidateService.getCandidateByEmail(candidate.getEmail());
		
		System.out.println(candidateDb);
		

		mailer.sendActivationLink("from@jobportal.com", "password", "candidate@gmail.com", "JobPortal - Activation Link", 
				"<a href=" + env.getProperty("app.url") +"jobportal/activationCandidate?uuid=" + candidateDb.get().getStatus() + "\">abc</a>");
		
//		System.out.println(uuid);
		
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	/*
	 * 
	 * Profile apis
	 */
	@GetMapping("/candidate/{id}/profile")
	public  Optional<CandidateProfile> getProfile(@PathVariable Long id) {
		return candidateService.getProfile(id);
	}
	
	@GetMapping("/candidate/{id}/profile/update")
	public  String updateProfile(@PathVariable Long id, @RequestBody CandidateProfile profile) {
		
		System.out.println(id);
		System.out.println(profile);
		
		//Vaildate whether Id is correct customer Id
		if(candidateService.getCandidateById(id).isPresent()) {
			Optional<Candidate> optionalCandidate = candidateService.getCandidateById(id);
			profile.setId(id);
			candidateService.saveProfile(profile);
			return "Profile Updated";
		}
		
		return "Profile not udpated, Candidate Id is not found";
	}
	
}
