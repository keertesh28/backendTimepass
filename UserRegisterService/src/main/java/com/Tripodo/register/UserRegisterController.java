package com.Tripodo.register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Tripodo.entity.User;
import com.Tripodo.service.MailService;
import com.Tripodo.service.UserRegisterService;

/*@CrossOrigin(origins = "http://localhost:9000")*/
@RestController
public class UserRegisterController 
{
	@Autowired
	UserRegisterService  registerservice;
	@Autowired
	MailService mailservice;

	@RequestMapping(value = "/users",method=RequestMethod.POST)
	private String register(@RequestBody User user)
	{		
		String registerflag = registerservice.Register(user);
		return registerflag;	
	}
  
	
	@RequestMapping(value = "/username",method=RequestMethod.POST)
	private String checkusername(@RequestBody User user)
	{		
		String userflag = registerservice.checkusername(user);
		return userflag;	
	}
	
	@RequestMapping(value = "/resetpassword",method=RequestMethod.POST)
	private String resetsavepassword(@RequestBody User user)
	{		
		String resetpassword = registerservice.checkpassword(user);
		return resetpassword;	
	}
	
	@RequestMapping(value = "/forgotpassword",method=RequestMethod.POST)
	private String Resetpwdmail(@RequestBody User user)
	{	
		mailservice.sendmail(user);
		return "true";
			
	}

}
