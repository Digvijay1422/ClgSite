package com.clg.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Colleges {
    @Id
    private String clgId;
    private String clgName;
    private String clgLocation;
    private String clgContact;
    private String clgEmail;
    private String address;
    private String description;
    private String ratings;
    private String streamsAvail;
    @OneToMany(mappedBy = "colleges",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Streams> streams = new ArrayList<>();

}
