package com.Tripodo.service;

import org.springframework.stereotype.Service;

import com.Tripodo.entity.User;

@Service
public interface UserRegisterService {

	public String Register(User user);

	public String checkusername(User user);

	public String checkpassword(User user);



}
