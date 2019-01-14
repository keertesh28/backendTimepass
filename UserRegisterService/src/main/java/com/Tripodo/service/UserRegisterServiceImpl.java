/**
 * 
 */
package com.Tripodo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tripodo.dataaccess.UserRegisterDao;
import com.Tripodo.entity.User;

/**
 * @author SPHINX
 *
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService 
{
	@Autowired
	private UserRegisterDao userregister;

	String registerstatus = "";
	String checkusername = "";
	String passwordreset = "";
	@Override
	public String Register(User userdetails)
	{
		userdetails.setRegDate(new Date());		
		int count = userregister.findUserExists(userdetails.getEmailAddress());
		if(count == 0)
		{
			if(userregister.save(userdetails)!= null)
			{
				registerstatus = "User registered successfully";	
			}
		}
		else
		{
			registerstatus = "The emailid is already in use";
		}
			
		return registerstatus;
	}
	@Override
	public String checkusername(User userdetails) 
	{
		
		int count = userregister.findUserNameExists(userdetails.getName());
		if(count == 0)
		{	
				checkusername = "User name allowed";	
		}
		else
		{
			checkusername = "User name exists";
		}
			
		return checkusername;
		
	}
	@Override
	public String checkpassword(User userdetails) {		
		String password = userregister.findPasswordExists(userdetails.getName());
		if(password.equals(userdetails.getPassword()))
		{	
			passwordreset = "Password cannot be the last 2 passwords";	
		}
		else
		{
			userdetails.setName(userdetails.getName());
			userdetails.setPassword(userdetails.getPassword());
			if(userregister.save(userdetails)!= null)
			{
			passwordreset = "Password reset successfully";
			}
		}
			
		return passwordreset;
	}
	
	

}
