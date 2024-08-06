package com.clg.services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg.Entities.Streams;
import com.clg.repo.StreamRepo;
import com.clg.services.StreamService;

@Service
public class StreamServiceImpl  implements StreamService{

    @Autowired
    private StreamRepo streamRepo;

    @Override
    public Streams save(Streams streams) {
        
        String id = UUID.randomUUID().toString();
        streams.setStreamId(id);
        return streamRepo.save(streams);


    }

    @Override
    public List<Streams> getStreamsByCollegeIdList(String id) {
        
        List<Streams> streams = streamRepo.findByCollegesClgId(id);
        return streams;
    }

    @Override
    public List<Streams> findAll() {
        return streamRepo.findAll();
    }
    
}
