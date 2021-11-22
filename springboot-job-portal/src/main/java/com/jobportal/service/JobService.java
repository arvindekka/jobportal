package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.Job;
import com.jobportal.model.candidate.CandidateJob;
import com.jobportal.repository.CandidateJobRepo;
import com.jobportal.repository.JobRepo;

@Service
public class JobService {

	@Autowired
	JobRepo jobRepo;
	

	@Autowired
	CandidateJobRepo candidateJobRepo;
	
	
	
	public void saveJob(Job job) {
		
		jobRepo.save(job);
	}
	

	public List<Job> getJobAll() {
		
		return (List<Job>) jobRepo.findAll();
	}


	public CandidateJob applyForJob(Long candidateId, Long jobId) {
		CandidateJob candidateJob = new CandidateJob();
		candidateJob.setCandidateId(candidateId);
		candidateJob.setJobId(jobId);
		candidateJobRepo.save(candidateJob);
		return candidateJob;
	}
	
}
