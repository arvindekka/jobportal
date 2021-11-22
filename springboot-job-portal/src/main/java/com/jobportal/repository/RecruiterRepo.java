package com.jobportal.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jobportal.model.Recruiter;

public interface RecruiterRepo extends CrudRepository<Recruiter, Long>{

	@Query("from Recruiter where id=:userId and password=:password")
	public Optional<Recruiter> authenticate(@Param("userId") Long userId, @Param("password") String password);

	@Query("from Recruiter where email=:email")
	public  Optional<Recruiter> getRecruiterByEmail(@Param("email") String email);

	@Query("from Recruiter where status=:uuid")
	public Optional<Recruiter> getRecruiterByUUIDStatus(@Param("uuid") String uuid);
	
	@Transactional
	@Modifying
	@Query("update Recruiter set loggedIn=false where id=:userId")
	public int logout(@Param("userId") Long userId);
	
}
