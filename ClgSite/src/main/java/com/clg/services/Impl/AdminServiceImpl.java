package com.clg.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clg.Entities.Admin;
import com.clg.Helper.AppConstants;
import com.clg.repo.AdminRepo;

@Service
public class AdminServiceImpl {
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
    AdminRepo repo;

    public Admin save(Admin admin)
    {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRoleList(List.of(AppConstants.ROLE_USER));
        return repo.save(admin);
        
    }
    public Optional<Admin> findByUsername(String username){
        return repo.findByUsername(username);
    }
}

