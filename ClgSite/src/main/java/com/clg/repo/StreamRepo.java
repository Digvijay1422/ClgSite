package com.clg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clg.Entities.Streams;

public interface StreamRepo extends JpaRepository<Streams,String>{
    
    
}
