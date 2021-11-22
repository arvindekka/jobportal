package com.jobportal.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jobportal.model.candidate.Candidate;

public interface CandidateRepo extends CrudRepository<Candidate, Long> {
	
	@Query("from candidate where id=:userId and password=:password")
	public Optional<Candidate> authenticate(@Param("userId") Long userId, @Param("password") String password);

	@Query("from candidate where email=:email")
	public  Optional<Candidate> getCandidateByEmail(@Param("email") String email);

	@Query("from candidate where status=:uuid")
	public Optional<Candidate> getCandidateByUUIDStatus(@Param("uuid") String uuid);

	@Transactional
	@Modifying
	@Query("update candidate set loggedIn=false where id=:userId")
	public int logout(@Param("userId") Long userId);
	
}