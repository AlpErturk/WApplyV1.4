package com.example.WApplyV14.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Candidate{

    @Id
    @Column(name="email")
    private String email;

    private String username;

    private String password;

    private String education;

    private String experience;

    private boolean canMakeJobApplication;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int candidateID;

    /*@OneToMany(mappedBy = "candidate", cascade = {CascadeType.ALL}) //500 HATASI İÇİN ORPHAN REMOVAL SİLİNDİ
    private List<JobApplication> candidateApplications;*/

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "candidate_applications", joinColumns = @JoinColumn(name = "candidate_email"))
    @AttributeOverrides({
            @AttributeOverride(name = "status", column = @Column(name = "status")),
            @AttributeOverride(name = "jobApplicationID", column = @Column(name = "job_application_id")),
            @AttributeOverride(name = "noticeID", column = @Column(name = "street"))
    })
    private Set<JobApplication> candidateApplications = new HashSet<>();

    /*public Candidate(String email, String username, String password, String education, String experience, boolean canMakeJobApplication, int candidateID) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.education = education;
        this.experience = experience;
        this.canMakeJobApplication = true;
        this.candidateID = candidateID;
    }*/


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public boolean getCanMakeJobApplication() {
        return canMakeJobApplication;
    }

    public void setCanMakeJobApplication(boolean canMakeJobApplication) {
        this.canMakeJobApplication = canMakeJobApplication;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public Set<JobApplication> getAppliedJobs() {
        return candidateApplications;
    }

    public void setAppliedJobs(Set<JobApplication> appliedJobs) {
        this.candidateApplications = appliedJobs;
    }
}
