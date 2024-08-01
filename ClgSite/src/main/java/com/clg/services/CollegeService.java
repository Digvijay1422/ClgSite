package com.clg.services;


import java.util.List;

import com.clg.Entities.Colleges;

public interface CollegeService {
    
    public Colleges save(Colleges college);

    public Colleges getCollegesById(String id);

    public List<Colleges> getAllColleges();
    
}
