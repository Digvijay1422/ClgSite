package com.clg.Entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
    @Column(length = 1000)
    private String description;
    private String cloudinaryImagePublicId;
    private String ratings;
    @Column(length = 1000)
    private String streamsAvail;
    private String picture;
    private String fees;
    private String link;
    @OneToMany(mappedBy = "colleges",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Streams> streams = new ArrayList<>();

}
