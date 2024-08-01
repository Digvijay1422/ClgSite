package com.clg.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class RootController {
    

    
	
	@ModelAttribute
	public void loggedInUserInfo(Model model,Authentication authentication)
	{
		if(authentication==null)
				return;
		// String username = Helper.getEmailOfLoggedInUser(authentication);
    	
    	// User user = userService.getUserByEmail(username);

    	// System.out.println(user.getEmail());
    	// System.out.println(user.getName());
    		
    	model.addAttribute("loggedInUser",true);
	}
    
}
