package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.model.candidate.CandidateResume;

public interface ResumeAttachmentRepo extends JpaRepository<CandidateResume, String>{

}
