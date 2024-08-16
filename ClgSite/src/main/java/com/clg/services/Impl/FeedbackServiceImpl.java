package com.clg.services.Impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg.Entities.Feedback;
import com.clg.repo.FeedBackRepo;
import com.clg.services.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedBackRepo fbRepo;

    @Override
    public Feedback save(Feedback fb) {
        String id = UUID.randomUUID().toString();
        fb.setId(id);
        return fbRepo.save(fb);
    }
    
}
