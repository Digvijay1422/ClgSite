package com.clg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.clg.Entities.Streams;

public interface StreamRepo extends JpaRepository<Streams,String>{
    
    
    List<Streams> findByCollegesClgId(String clgId);
}
