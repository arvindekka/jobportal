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

import com.jobportal.model.Recruiter;
import com.jobportal.model.candidate.Candidate;
import com.jobportal.model.candidate.CandidateProfile;
import com.jobportal.notification.Mailer;
import com.jobportal.service.RecruiterService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecruiterController {
	
	@Autowired
	RecruiterService recruiterService;
	
	@Autowired
	Mailer mailer;
	
	@Autowired
	Environment env;
	
	private static Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	@RequestMapping("/recruiter/{id}")
	public Optional<Recruiter> getCandidateDetails(@PathVariable Long id) {
		System.out.println(id);
		return recruiterService.getRecruiterById(id);
	}
	
	@GetMapping("/recruiters")
	public  List<Recruiter> getCandidateAll() {
		return recruiterService.getRecruiterAll();
	}
	
	@PostMapping("/recruiter/create")
	public  ResponseEntity<String> registerCandidate(@RequestBody Recruiter recruiter) {

//		System.out.println(candidate);
		recruiterService.registerRecruiter(recruiter);
		Optional<Recruiter> candidateDb = recruiterService.getRecruiterByEmail(recruiter.getEmail());
		
		System.out.println(candidateDb);
		

		mailer.sendActivationLink("from@jobportal.com", "password", "candidate@gmail.com", "JobPortal - Activation Link", 
				"<a href=" + env.getProperty("app.url") +"jobportal/activationRecruiter?uuid=" + candidateDb.get().getStatus() + "\">abc</a>");
		
//		System.out.println(uuid);
		
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	/*
	 * 
	 * Profile apis
	 */
	@GetMapping("/recruiter/{id}/profile")
	public  Optional<Recruiter> getProfile(@PathVariable Long id) {
		return recruiterService.getRecruiterById(id);
	}
	
	@GetMapping("/recruiter/{id}/profile/update")
	public  String updateProfile(@PathVariable Long id, @RequestBody Recruiter profile) {
		
		System.out.println(id);
		System.out.println(profile);
		
		//Vaildate whether Id is correct customer Id
		if(recruiterService.getRecruiterById(id).isPresent()) {
			Optional<Recruiter> optionalRecruiter = recruiterService.getRecruiterById(id);
			Recruiter r = optionalRecruiter.get();
			System.out.println(r);
			profile.setId(id);
			profile.setCompanyName(profile.getCompanyName()==null?r.getCompanyName():profile.getCompanyName());
			profile.setEmail(profile.getEmail()==null?r.getEmail():profile.getEmail());
			profile.setName(profile.getName()==null?r.getName():profile.getName());
			profile.setStatus(profile.getStatus()==null?r.getStatus():profile.getStatus());

			recruiterService.saveProfile(profile);
			return "Profile Updated";
		}
		
		return "Profile not udpated, Candidate Id is not found";
	}
	
}
