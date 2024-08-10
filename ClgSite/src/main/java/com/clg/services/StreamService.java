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

    //Considering Streams
    public List<Streams> findByCutOffGenaralStreams(@Param("marks") float marks , String streamName);
    public List<Streams> findByCutOffVjStreams(@Param("marks") float marks , String streamName);
    public List<Streams> findByCutOffScStreams(@Param("marks") float marks , String streamName);
    public List<Streams> findByCutOffNt1Streams(@Param("marks") float marks , String streamName);
    public List<Streams> findByCutOffNt2Streams(@Param("marks") float marks , String streamName);
    public List<Streams> findByCutOffNt3Streams(@Param("marks") float marks , String streamName);
    public List<Streams> findByCutOffObcStreams(@Param("marks") float marks , String streamName);
    public List<Streams> findByCutOffTfwsStreams(@Param("marks") float marks , String streamName);

    //Location, stream, qoota
    public List<Streams> findByCuttOffGeneralLocation(float marks,String name,String location);
    public List<Streams> findByCuttOffScLocation(float marks,String name,String location);
    public List<Streams> findByCuttOffVjLocation(float marks,String name,String location);
    public List<Streams> findByCuttOffNt1Location(float marks,String name,String location);
    public List<Streams> findByCuttOffNt2Location(float marks,String name,String location);
    public List<Streams> findByCuttOffNt3Location(float marks,String name,String location);
    public List<Streams> findByCuttOffObcLocation(float marks,String name,String location);
    public List<Streams> findByCuttOffTfwsLocation(float marks,String name,String location);
    
}
