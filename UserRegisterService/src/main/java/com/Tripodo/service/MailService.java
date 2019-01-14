package com.Tripodo.service;

import org.springframework.stereotype.Service;

import com.Tripodo.entity.User;

@Service
public interface MailService 
{

  public void sendmail(User user);

}
