package com.clg.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clg.repo.AdminRepo;

@Service
public class SecurityCustomUserDeatilService implements UserDetailsService{

	@Autowired
	private AdminRepo userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails=  userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
		return userDetails;
	}

	
}
