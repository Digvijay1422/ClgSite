package com.clg.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.clg.Entities.Streams;

public interface StreamService {
    
    public Streams save(Streams streams);

    public List<Streams> getStreamsByCollegeIdList(String id);
    
    public List<Streams> findAll();

    public List<Streams> findByCutOffGenaral(@Param("marks") float marks);
    public List<Streams> findByCutOffSc(@Param("marks") float marks);
    public List<Streams> findByCutOffVj(@Param("marks") float marks);
    public List<Streams> findByCutOffNt1(@Param("marks") float marks);
    public List<Streams> findByCutOffNt2(@Param("marks") float marks);
    public List<Streams> findByCutOffNt3(@Param("marks") float marks);
    public List<Streams> findByCutOffObc(@Param("marks") float marks);
    public List<Streams> findByCutOffTfws(@Param("marks") float marks);
}
