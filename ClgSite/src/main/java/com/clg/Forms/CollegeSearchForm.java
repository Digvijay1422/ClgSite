package com.clg.Forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CollegeSearchForm {
    
    private float cetMarks;
    private int pcmMarks=150;
    private String qouta="open";
    private String stream="all";
    private String location="kolhapur";
    private String autonomous="yes";

}
