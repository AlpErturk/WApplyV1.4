package com.example.WApplyV14.commands;


import com.example.WApplyV14.model.JobApplication;

import java.util.Date;
import java.util.List;

public class JobNoticeForm {
    private int jobNoticeID;
    private String description;
    private String qualifications;
    private String relatedCompany;
    private String relatedAdmin;
    private boolean isActive; //as status of job notice
    private Date futureStatusChangeOfNotice;
    private boolean futureStatus; //Active or passive job notice
    private List<JobApplication> currentApplications;

    public int getJobNoticeID() {
        return jobNoticeID;
    }

    public void setJobNoticeID(int jobNoticeID) {
        this.jobNoticeID = jobNoticeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getRelatedCompany() {
        return relatedCompany;
    }

    public void setRelatedCompany(String relatedCompany) {
        this.relatedCompany = relatedCompany;
    }

    public String getRelatedAdmin() {
        return relatedAdmin;
    }

    public void setRelatedAdmin(String relatedAdmin) {
        this.relatedAdmin = relatedAdmin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getFutureStatusChangeOfNotice() {
        return futureStatusChangeOfNotice;
    }

    public void setFutureStatusChangeOfNotice(Date futureStatusChangeOfNotice) {
        this.futureStatusChangeOfNotice = futureStatusChangeOfNotice;
    }

    public boolean getFutureStatus() {
        return futureStatus;
    }

    public void setFutureStatus(boolean futureStatus) {
        this.futureStatus = futureStatus;
    }

    public List<JobApplication> getCurrentApplications() {
        return currentApplications;
    }

    public void setCurrentApplications(List<JobApplication> currentApplications) {
        this.currentApplications = currentApplications;
    }
}
