package com.clg.Forms;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Name is required!!")
    private String clgName;
    @NotBlank
    private String clgLocation;
    @Size(min = 8, max = 12,message = "Enter valid number")
    private String clgContact;
    @Email(message = "Invalid email!!")
    private String clgEmail;
    private String link;
    private String fees;
    @NotBlank
    private String address;
    @NotBlank
    private String description;
    private boolean autonomous=false;
    private String ratings;
    private String medianSalary;
    @NotBlank
    private int streamsAvail;
    private MultipartFile picture;
    private String stringPicture;
}
