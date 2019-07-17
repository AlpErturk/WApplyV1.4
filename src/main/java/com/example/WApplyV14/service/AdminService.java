package com.example.WApplyV14.service;


import com.example.WApplyV14.commands.JobNoticeForm;
import com.example.WApplyV14.model.Candidate;
import com.example.WApplyV14.model.JobApplication;
import com.example.WApplyV14.model.JobNotice;

import java.util.List;
import java.util.Set;

public interface AdminService {

    public JobNotice createOrUpdateJobNotice(JobNotice jobNotice);

    //public List<Candidate> seeAppliedCandidates(JobNotice jobNotice);

    //public List<JobApplication> seeOtherApplicationsOfCandidate(Candidate candidate);

    public void deleteJobNotice(int jobNoticeID);

    //CREATE A METHOD TO SEE PROFILE OF DESIRED CANDIDATE OF JOB NOTCIE//
    //CREATE A METHOD TO SEE PROFILE OF DESIRED CANDIDATE OF JOB NOTCIE//

    public void changeStatusOfJobApplication(JobApplication jobApplication, JobApplication.applicationStatus status);

    //IMPLEMENT IT LATER
    public void sendEmailToCandidate(JobApplication jobApplication);

    //filter applications by status
    public Set<JobApplication> filteredApplications(JobNotice jobNotice, JobApplication.applicationStatus status);

    //KARA LİSTEYE ALMA
    public void putCandidateToBlackList(Candidate candidate, String description, String email);

    public List<Candidate> listAllCandidates();

    public List<JobApplication> listAllApplications();

    public List<JobNotice> listAllJobNotices();

    public JobNotice saveOrUpdateJobNoticeForm(JobNoticeForm jobNoticeForm);

    public JobNotice getByJobNoticeID(int jobNoticeID);

    public JobApplication getByJobApplicationID(int jobApplicationID);
}
