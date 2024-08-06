package com.clg.services;

import java.util.List;
import com.clg.Entities.Streams;

public interface StreamService {
    
    public Streams save(Streams streams);

    public List<Streams> getStreamsByCollegeIdList(String id);
    
    public List<Streams> findAll();
}
