package com.Tripodo.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tripodo.dataaccess.EmailTokenDao;
import com.Tripodo.entity.Email;
import com.Tripodo.entity.User;
import com.fasterxml.uuid.Generators;

@Service
public class MailServiceImpl implements MailService {
	
	
	@Autowired
	EmailTokenDao usertoken;
	

	public void sendmail(User user,Email email) {
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("rohitjharkhand@gmail.com", "12qwas..");
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			String token = Generators.randomBasedGenerator().generate().toString();
			String mailBody ="http://localhost:8080/verifytoken/"+ token ;
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmailAddress()));
			message.setSubject("Passowrd Reset Email");
			message.setText(mailBody);
			// send message
			Transport.send(message);
			email.setEmail(user.getEmailAddress());
			email.setToken(token);
			email.setExpirationdate(System.currentTimeMillis());
			usertoken.save(email);			
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean checktokenexpiry(String token) 
	{		
		Long expirytime = Long.parseLong(usertoken.findtokenexpiry(token));
		Long currenttime = System.currentTimeMillis();
		if((currenttime-expirytime)> 300000)
		{
			return false;
		}
		else
		{
		return true;
		}
	}
}


