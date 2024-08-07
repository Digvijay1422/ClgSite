package com.clg.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Streams {
    @Id
    private String streamId;
    private String streamName;
    private String streamDuration;
    private float openQuotaCuttOff;
    private float scQuotaCuttOff;
    private float vjQuotaCuttOff;
    private float nt1QuotaCuttOff;
    private float nt2QuotaCuttOff;
    private float nt3QuotaCuttOff;
    private float obcQuotaCuttOff;
    private float tfwsQuotaCuttOff;

    
    @ManyToOne
    @JsonIgnore
    private Colleges colleges;

    


}
