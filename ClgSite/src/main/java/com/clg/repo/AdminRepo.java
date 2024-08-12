package com.clg.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clg.Entities.Admin;;

@Repository
public interface AdminRepo extends JpaRepository<Admin,String> {

    public Optional<Admin> findByUsername(String username);
    
}
