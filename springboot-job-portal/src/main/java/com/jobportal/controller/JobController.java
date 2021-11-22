package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.model.Job;
import com.jobportal.model.candidate.CandidateJob;
import com.jobportal.service.JobService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobController {
	
	@Autowired
	JobService jobService;

	@PostMapping("/jobPosting")
	public String postJob(@RequestBody Job job) {
		
		System.out.println(job);
		System.out.println(job.getRecruiter());
		jobService.saveJob(job);
		return "o kok";
	}
	

	@GetMapping("/getAllJobs")
	public List<Job> getAllJob() {
		
		
		return jobService.getJobAll();
	}
	
	@PostMapping("/applyForJob")
	public CandidateJob applyForJob(@RequestParam Long candidateId, @RequestParam Long jobId) {
		
//		jobService.applyForJob(candidateId, jobId);
		
		return jobService.applyForJob(candidateId, jobId);
	}
}
