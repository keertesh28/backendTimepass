package com.Tripodo.dataaccess;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Tripodo.entity.User;

@Repository
public interface UserRegisterDao extends JpaRepository<User, Integer>
{
	
	@Query("Select count(*) from User u where u.emailAddress = ?1")
	int findUserExists(String emailid);
	
	@Query("Select count(*) from User u where u.name = ?1")
	int findUserNameExists(String user);

	@Query("Select password from User u where u.name = ?1")
	String findPasswordExists(String user);

}
