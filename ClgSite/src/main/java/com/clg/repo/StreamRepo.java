package com.clg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clg.Entities.Streams;

public interface StreamRepo extends JpaRepository<Streams,String>{
    
    
    List<Streams> findByCollegesClgId(String clgId);

    List<Streams> findAll();

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
}
