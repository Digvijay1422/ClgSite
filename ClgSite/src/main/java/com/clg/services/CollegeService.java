package com.clg.services;

import java.util.Optional;

import com.clg.Entities.Colleges;

public interface CollegeService {
    
    public Colleges save(Colleges college);

    public Colleges getCollegesById(String id);
    
}
