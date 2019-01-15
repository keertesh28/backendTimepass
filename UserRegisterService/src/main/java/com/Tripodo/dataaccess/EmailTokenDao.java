package com.Tripodo.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Tripodo.entity.Email;

@Repository
public interface EmailTokenDao extends JpaRepository<Email, Integer>

{
	
	@Query("Select expirationdate from Email e where e.token = ?1")
	String findtokenexpiry(String token);

}
