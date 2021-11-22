package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.model.candidate.CandidateJob;

public interface CandidateJobRepo extends CrudRepository<CandidateJob, Long>{

}