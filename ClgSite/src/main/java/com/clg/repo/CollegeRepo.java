package com.clg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clg.Entities.Colleges;

@Repository
public interface CollegeRepo extends JpaRepository<Colleges,String> {
    
     
}
