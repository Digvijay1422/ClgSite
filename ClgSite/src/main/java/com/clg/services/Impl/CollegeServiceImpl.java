package com.clg.services.Impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg.Entities.Colleges;
import com.clg.repo.CollegeRepo;
import com.clg.services.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepo collegeRepo;

    @Override
    public Colleges save(Colleges college) {
        String id = UUID.randomUUID().toString();
        college.setClgId(id);
       return collegeRepo.save(college);
    }


    
}
