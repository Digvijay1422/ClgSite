package com.clg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clg.Entities.Streams;

@Repository
public interface StreamRepo extends JpaRepository<Streams,String>{
    
    
    List<Streams> findByCollegesClgId(String clgId);

    List<Streams> findAll();

    // Queries for input -> marks, location_all, qouta 

     @Query("SELECT s FROM Streams s WHERE s.openQuotaCuttOff<:marks  ORDER BY s.openQuotaCuttOff DESC")
    List<Streams> findByCutOffGenaral(@Param("marks") float marks);

     @Query("SELECT s FROM Streams s WHERE s.scQuotaCuttOff <= :marks  ORDER BY s.scQuotaCuttOff DESC")
    List<Streams> findByCutOffSc(@Param("marks") float marks);

     @Query("SELECT s FROM Streams s WHERE s.vjQuotaCuttOff <= :marks  ORDER BY s.vjQuotaCuttOff DESC")
    List<Streams> findByCutOffVj(@Param("marks") float marks);

     @Query("SELECT s FROM Streams s WHERE s.nt1QuotaCuttOff <= :marks  ORDER BY s.nt1QuotaCuttOff DESC")
    List<Streams> findByCutOffNt1(@Param("marks") float marks);

     @Query("SELECT s FROM Streams s WHERE s.nt2QuotaCuttOff <= :marks  ORDER BY s.nt2QuotaCuttOff DESC")
    List<Streams> findByCutOffNt2(@Param("marks") float marks);

     @Query("SELECT s FROM Streams s WHERE s.nt3QuotaCuttOff <= :marks  ORDER BY s.nt3QuotaCuttOff DESC")
    List<Streams> findByCutOffNt3(@Param("marks") float marks);

     @Query("SELECT s FROM Streams s WHERE s.obcQuotaCuttOff <= :marks  ORDER BY s.obcQuotaCuttOff DESC")
    List<Streams> findByCutOffObc(@Param("marks") float marks);

     @Query("SELECT s FROM Streams s WHERE s.tfwsQuotaCuttOff <= :marks  ORDER BY s.tfwsQuotaCuttOff DESC")
    List<Streams> findByCutOffTfws(@Param("marks") float marks);

    
    //Considering streamss

    @Query("SELECT s FROM Streams s WHERE s.streamName= :name AND s.openQuotaCuttOff<= :marks ORDER BY s.openQuotaCuttOff DESC")
    List<Streams> findByCuttOffGeneralStream(@Param("marks") float marks, @Param("name") String streamName);

    @Query("SELECT s FROM Streams s WHERE s.streamName= :name AND s.scQuotaCuttOff<= :marks ORDER BY s.scQuotaCuttOff DESC" )
    List<Streams> findByCuttOffScStream(@Param("marks") float marks, @Param("name") String streamName);
    
    @Query("SELECT s FROM Streams s WHERE s.streamName= :name AND s.vjQuotaCuttOff<= :marks ORDER BY s.vjQuotaCuttOff DESC" )
    List<Streams> findByCuttOffVjStream(@Param("marks") float marks, @Param("name") String streamName);
    
    @Query("SELECT s FROM Streams s WHERE s.streamName= :name AND s.nt1QuotaCuttOff<= :marks ORDER BY s.nt1QuotaCuttOff DESC" )
    List<Streams> findByCuttOffNt1Stream(@Param("marks") float marks, @Param("name") String streamName);
    
    @Query("SELECT s FROM Streams s WHERE s.streamName= :name AND s.nt2QuotaCuttOff<= :marks ORDER BY s.nt2QuotaCuttOff DESC" )
    List<Streams> findByCuttOffNt2Stream(@Param("marks") float marks, @Param("name") String streamName);
    
    @Query("SELECT s FROM Streams s WHERE s.streamName= :name AND s.nt3QuotaCuttOff<= :marks ORDER BY s.nt3QuotaCuttOff DESC" )
    List<Streams> findByCuttOffNt3Stream(@Param("marks") float marks, @Param("name") String streamName);
    
    @Query("SELECT s FROM Streams s WHERE s.streamName= :name AND s.obcQuotaCuttOff<= :marks ORDER BY s.obcQuotaCuttOff DESC" )
    List<Streams> findByCuttOffObcStream(@Param("marks") float marks, @Param("name") String streamName);
    
    @Query("SELECT s FROM Streams s WHERE s.streamName= :name AND s.tfwsQuotaCuttOff<= :marks ORDER BY s.tfwsQuotaCuttOff DESC" )
    List<Streams> findByCuttOffTfwsStream(@Param("marks") float marks, @Param("name") String streamName);

    
    
    //Considering location, Streams, Quota
     @Query("SELECT s FROM Streams s WHERE s.tfwsQuotaCuttOff <= :marks AND s.colleges.clgLocation=:location AND s.streamName=:name  ORDER BY s.tfwsQuotaCuttOff DESC")
    List<Streams> findByCutOffTfwsLocation(@Param("marks") float marks,@Param("name") String name,@Param("location") String location);

    @Query("SELECT s FROM Streams s WHERE s.openQuotaCuttOff <= :marks AND s.streamName = :name AND  s.colleges.clgLocation = :location")
    List<Streams> findByCutOffOpenLocation(@Param("marks") float marks,@Param("name") String name,@Param("location") String location);

     @Query("SELECT s FROM Streams s WHERE s.scQuotaCuttOff <= :marks AND s.colleges.clgLocation=:location AND s.streamName=:name  ORDER BY s.scQuotaCuttOff DESC")
    List<Streams> findByCutOffScLocation(@Param("marks") float marks,@Param("name") String name,@Param("location") String location);

     @Query("SELECT s FROM Streams s WHERE s.vjQuotaCuttOff <= :marks AND s.colleges.clgLocation=:location AND s.streamName=:name  ORDER BY s.vjQuotaCuttOff DESC")
    List<Streams> findByCutOffVjLocation(@Param("marks") float marks,@Param("name") String name,@Param("location") String location);
     @Query("SELECT s FROM Streams s WHERE s.nt1QuotaCuttOff <= :marks AND s.colleges.clgLocation=:location AND s.streamName=:name  ORDER BY s.tfwsQuotaCuttOff DESC")
    List<Streams> findByCutOffNt1Location(@Param("marks") float marks,@Param("name") String name,@Param("location") String location);

     @Query("SELECT s FROM Streams s WHERE s.nt2QuotaCuttOff <= :marks AND s.colleges.clgLocation=:location AND s.streamName=:name  ORDER BY s.tfwsQuotaCuttOff DESC")
    List<Streams> findByCutOffNt2Location(@Param("marks") float marks,@Param("name") String name,@Param("location") String location);

     @Query("SELECT s FROM Streams s WHERE s.nt3QuotaCuttOff <= :marks AND s.colleges.clgLocation=:location AND s.streamName=:name  ORDER BY s.tfwsQuotaCuttOff DESC")
    List<Streams> findByCutOffNt3Location(@Param("marks") float marks,@Param("name") String name,@Param("location") String location);
    
     @Query("SELECT s FROM Streams s WHERE s.obcQuotaCuttOff <= :marks AND s.colleges.clgLocation=:location AND s.streamName=:name  ORDER BY s.tfwsQuotaCuttOff DESC")
    List<Streams> findByCutOffObcLocation(@Param("marks") float marks,@Param("name") String name,@Param("location") String location);

}    
