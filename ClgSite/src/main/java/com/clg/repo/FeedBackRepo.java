package com.clg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clg.Entities.Feedback;

public interface FeedBackRepo extends JpaRepository<Feedback,String>{

   
}
