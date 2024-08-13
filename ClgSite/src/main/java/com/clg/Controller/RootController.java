package com.clg.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.clg.Entities.Admin;
import com.clg.Helper.Helper;
import com.clg.services.Impl.AdminServiceImpl;

public class RootController {
    
	@Autowired
	private AdminServiceImpl adminServiceImpl;
    
	
	@ModelAttribute
	public void loggedInUserInfo(Model model,Authentication authentication)
	{
		if(authentication==null)
				return;
		String username = Helper.getEmailOfLoggedInUser(authentication);
    	
    	Optional<Admin> user = adminServiceImpl.findByUsername(username);


    	// System.out.println(user.getName());
    		
    	model.addAttribute("user",user);
	}
    
}
