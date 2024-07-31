package com.clg.Entities;


import java.util.Optional;

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
    private String quota;
    private String cutOff;
    private String streamName;
    private String streamDuration;

    @ManyToOne
    private Colleges colleges;

    


}
