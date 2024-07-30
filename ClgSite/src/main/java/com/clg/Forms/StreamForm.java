package com.clg.Forms;

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
@ToString
@Builder
public class StreamForm {
    
    private String streamId;
    private String quota;
    private String cutOff;
    private String streamName;
    private String collegeId;
    private String streamFees;
    private String streamDuration;
}
