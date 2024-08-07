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

    @Override
    public List<Streams> findByCutOffGenaral(float marks) {
        System.out.println("In impl"+marks);
        return streamRepo.findByCutOffGenaral(marks);

    }

    @Override
    public List<Streams> findByCutOffSc(float marks) {
        return streamRepo.findByCutOffSc(marks);
    }

    @Override
    public List<Streams> findByCutOffVj(float marks) {
       
        return streamRepo.findByCutOffVj(marks);
    }

    @Override
    public List<Streams> findByCutOffNt1(float marks) {
        return streamRepo.findByCutOffNt1(marks);
    }

    @Override
    public List<Streams> findByCutOffNt2(float marks) {
       return streamRepo.findByCutOffNt2(marks);
    }

    @Override
    public List<Streams> findByCutOffNt3(float marks) {
        return streamRepo.findByCutOffNt3(marks);
    }

    @Override
    public List<Streams> findByCutOffObc(float marks) {
       return streamRepo.findByCutOffObc(marks);
    }

    @Override
    public List<Streams> findByCutOffTfws(float marks) {
        return streamRepo.findByCutOffTfws(marks);
    }

    
    
}
