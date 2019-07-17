package com.example.WApplyV14.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
public class JobApplication {

    @Id
    @Column(name = "jobApplicationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobApplicationID;

    //private String candidateEmail;

    private applicationStatus status;

   // @Column(name = "notice_id")
    //private int noticeID;

    //@Column(name = "notice_id2", insertable = false, updatable = false) //DUPLICTED COLUMN HATASINDAN DOLAYI İNSERT,UPDATE = FALSE YAPILDI
    //private int noticeID2;

    public enum applicationStatus {
        ACCEPTED,
        DECLINED,
        ON_PROCESS;
    }

    /*@ManyToOne
    @JoinColumn(name = "email")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "jobNoticeID")
    private JobNotice jobNotice;*/

    /*public JobApplication(String candidateEmail, int jobApplicationID, int jobNoticeID) {
        this.candidateEmail = candidateEmail;
        this.jobApplicationID = jobApplicationID;
        this.status = applicationStatus.ON_PROCESS;
        this.jobNoticeID = jobNoticeID;
    }*/

    public applicationStatus getStatus() {
        return status;
    }

    public void setStatus(applicationStatus status) {
        this.status = status;
    }

    public int getJobApplicationID() {
        return jobApplicationID;
    }

    public void setJobApplicationID(int jobApplicationID) {
        this.jobApplicationID = jobApplicationID;
    }

   /* public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

   public int getJobNoticeID() {
        return noticeID;
    }

    public void setJobNoticeID(int jobNoticeID) {
        this.noticeID = jobNoticeID;
        //this.noticeID2 = jobNoticeID;
    }*/




}