package com.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jobportal.model.candidate.CandidateProfile;

public interface CandidateProfileRepo extends CrudRepository<CandidateProfile, Long> {
	
	@Query(value="from candidate_profile where id=:id", nativeQuery = true)
	public  Optional<CandidateProfile> getProfile(@Param("id") Long id);
	
	/*
	 * Getting error on
	 * Caused by: org.hibernate.hql.internal.ast.QuerySyntaxException: CandidateProfie is not mapped
	 *
	 */
//	@Query("from CandidateProfie where id=:id")
//	public  Optional<CandidateProfile> getProfile2(@Param("id") String id);
	
	
	
}