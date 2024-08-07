package com.clg.Forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Getter
// @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StreamForm {
    
    private String streamId;
    private String streamName;
    private String collegeId;
    private String streamFees;
    private float openQuotaCuttOff;
    private float scQuotaCuttOff;
    private float vjQuotaCuttOff;
    private float nt1QuotaCuttOff;
    private float nt2QuotaCuttOff;
    private float nt3QuotaCuttOff;
    private float obcQuotaCuttOff;
    private float tfwsQuotaCuttOff;

    private String streamDuration;

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getStreamFees() {
        return streamFees;
    }

    public void setStreamFees(String streamFees) {
        this.streamFees = streamFees;
    }

    public float getOpenQuotaCuttOff() {
        return openQuotaCuttOff;
    }

    public void setOpenQuotaCuttOff(float openQuotaCuttOff) {
        this.openQuotaCuttOff = openQuotaCuttOff;
    }

    public float getScQuotaCuttOff() {
        return scQuotaCuttOff;
    }

    public void setScQuotaCuttOff(float scQuotaCuttOff) {
        this.scQuotaCuttOff = scQuotaCuttOff;
    }

    public float getVjQuotaCuttOff() {
        return vjQuotaCuttOff;
    }

    public void setVjQuotaCuttOff(float vjQuotaCuttOff) {
        this.vjQuotaCuttOff = vjQuotaCuttOff;
    }

    public float getNt1QuotaCuttOff() {
        return nt1QuotaCuttOff;
    }

    public void setNt1QuotaCuttOff(float nt1QuotaCuttOff) {
        this.nt1QuotaCuttOff = nt1QuotaCuttOff;
    }

    public float getNt2QuotaCuttOff() {
        return nt2QuotaCuttOff;
    }

    public void setNt2QuotaCuttOff(float nt2QuotaCuttOff) {
        this.nt2QuotaCuttOff = nt2QuotaCuttOff;
    }

    public float getNt3QuotaCuttOff() {
        return nt3QuotaCuttOff;
    }

    public void setNt3QuotaCuttOff(float nt3QuotaCuttOff) {
        this.nt3QuotaCuttOff = nt3QuotaCuttOff;
    }

    public float getObcQuotaCuttOff() {
        return obcQuotaCuttOff;
    }

    public void setObcQuotaCuttOff(float obcQuotaCuttOff) {
        this.obcQuotaCuttOff = obcQuotaCuttOff;
    }

    public float getTfwsQuotaCuttOff() {
        return tfwsQuotaCuttOff;
    }

    public void setTfwsQuotaCuttOff(float tfwsQuotaCuttOff) {
        this.tfwsQuotaCuttOff = tfwsQuotaCuttOff;
    }

    public String getStreamDuration() {
        return streamDuration;
    }

    public void setStreamDuration(String streamDuration) {
        this.streamDuration = streamDuration;
    }

   
}
