package com.clg.Entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
