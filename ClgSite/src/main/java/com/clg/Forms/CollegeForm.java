package com.clg.Forms;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CollegeForm {
    
    private String clgId;
    private String clgName;
    private String clgLocation;
    private String clgContact;
    private String clgEmail;
    private String address;
    private String description;
    private String ratings;
    private String streamsAvail;
    private MultipartFile picture;
}
