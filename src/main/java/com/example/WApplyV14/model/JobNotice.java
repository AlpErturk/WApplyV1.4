package com.example.WApplyV14.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class JobNotice{

    @Id
    @Column(name="jobNoticeID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int jobNoticeID;

    private String description;

    private String qualifications;

    private String relatedCompany;

    private String relatedAdmin;

    private boolean isActive; //as status of job notice

    private Date futureStatusChangeOfNotice;

    private boolean futureStatus; //Active or passive job notice

    /*@OneToMany(mappedBy = "jobNotice", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<JobApplication> noticeApplications;*/

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "notice_applications", joinColumns = @JoinColumn(name = "notice_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "status", column = @Column(name = "status")),
            @AttributeOverride(name = "jobApplicationID", column = @Column(name = "job_application_id")),
            @AttributeOverride(name = "candidateEmail", column = @Column(name = "candidate_email"))
    })
    private Set<JobApplication> noticeApplications = new HashSet<>();

    /*public JobNotice(String description, String qualifications, String relatedCompany, String relatedAdmin, boolean isActive, Date futureStatusChangeOfNotice, boolean futureStatus) {
        this.description = description;
        this.qualifications = qualifications;
        this.relatedCompany = relatedCompany;
        this.relatedAdmin = relatedAdmin;
        this.isActive = isActive;
        this.futureStatusChangeOfNotice = futureStatusChangeOfNotice;
        this.futureStatus = futureStatus;
        this.currentApplications = null;
    }*/

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

    public Set<JobApplication> getApplications() {
        return noticeApplications;
    }

    public void setApplications(Set<JobApplication> currentApplications) {
        this.noticeApplications = currentApplications;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}