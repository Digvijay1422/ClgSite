package com.clg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clg.Entities.Colleges;

public interface CollegeRepo extends JpaRepository<Colleges,String> {
    
    

    
}
