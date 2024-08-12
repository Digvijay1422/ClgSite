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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Colleges {
    @Id
    private String clgId;
    @NotBlank
    private String clgName;
    @NotBlank
    private String clgLocation;
    @NotBlank
    private String clgContact;
    private String clgEmail;
    private String address;
    private String medianSalary;

    @Column(length = 1000)
    private String description;
    private String cloudinaryImagePublicId;
    private String ratings;
    private int streamsAvail;
    private boolean autonomous=false;
    private String picture;
    private String fees;
    private String link;
    @OneToMany(mappedBy = "colleges",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Streams> streams = new ArrayList<>();

}