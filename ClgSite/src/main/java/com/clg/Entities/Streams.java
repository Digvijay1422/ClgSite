package com.clg.Entities;


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
    private String qoata;
    private String cutOff;
    private String streamName;
    @ManyToOne
    private Colleges colleges;


}
