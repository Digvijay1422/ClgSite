package com.clg.services.Impl;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Colleges getCollegesById(String id) {
        return collegeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Colleges> getAllColleges() {
       
        List<Colleges> colleges = collegeRepo.findAll();

        return colleges;
    }


    
}
