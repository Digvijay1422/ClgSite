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


    //Streams
    @Override
    public List<Streams> findByCutOffGenaralStreams(float marks,String name) {
        return streamRepo.findByCuttOffGeneralStream(marks, name);
    }

    
    @Override
    public List<Streams> findByCutOffVjStreams(float marks, String streamName) {
       return streamRepo.findByCuttOffVjStream(marks, streamName);
    }

    @Override
    public List<Streams> findByCutOffScStreams(float marks, String streamName) {
       return streamRepo.findByCuttOffScStream(marks, streamName);
    }

    @Override
    public List<Streams> findByCutOffNt1Streams(float marks, String streamName) {
       return streamRepo.findByCuttOffNt1Stream(marks, streamName);
    }

    @Override
    public List<Streams> findByCutOffNt2Streams(float marks, String streamName) {
        return streamRepo.findByCuttOffNt2Stream(marks, streamName);
    }

    @Override
    public List<Streams> findByCutOffNt3Streams(float marks, String streamName) {
       return streamRepo.findByCuttOffNt3Stream(marks, streamName);
    }
    
    @Override
    public List<Streams> findByCutOffObcStreams(float marks, String streamName) {
       return streamRepo.findByCuttOffObcStream(marks, streamName);
    }

    @Override
    public List<Streams> findByCutOffTfwsStreams(float marks, String streamName) {
        return streamRepo.findByCuttOffTfwsStream(marks, streamName);
    }

    
    
    //location,stream, qouta

    public List<Streams> findByCuttOffGeneralLocation(float marks,String name,String location)
    {
        
        return streamRepo.findByCutOffOpenLocation(marks, name, location);
    }

    @Override
    public List<Streams> findByCuttOffScLocation(float marks, String name, String location) {
      return streamRepo.findByCutOffScLocation(marks, name, location);
    }

    @Override
    public List<Streams> findByCuttOffVjLocation(float marks, String name, String location) {
        return streamRepo.findByCutOffVjLocation(marks, name, location);
    }

    @Override
    public List<Streams> findByCuttOffNt1Location(float marks, String name, String location) {
       return streamRepo.findByCutOffNt1Location(marks, name, location);
    }

    @Override
    public List<Streams> findByCuttOffNt2Location(float marks, String name, String location) {
        return streamRepo.findByCutOffNt2Location(marks, name, location);
    }

    @Override
    public List<Streams> findByCuttOffNt3Location(float marks, String name, String location) {
        return streamRepo.findByCutOffNt3Location(marks, name, location);
    }

    @Override
    public List<Streams> findByCuttOffObcLocation(float marks, String name, String location) {
        return streamRepo.findByCutOffObcLocation(marks, name, location);
    }

    @Override
    public List<Streams> findByCuttOffTfwsLocation(float marks, String name, String location) {
       return streamRepo.findByCutOffTfwsLocation(marks, name, location);
    }
    
    
}
