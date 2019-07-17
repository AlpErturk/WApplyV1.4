package com.example.WApplyV14.service;


import com.example.WApplyV14.model.Candidate;
import com.example.WApplyV14.model.JobApplication;

import java.util.List;

public interface CandidateService {

    public Candidate createOrUpdateCandidate(Candidate candidate);

    public void makeJobApplication(String email, int jobNoticeID, int jobApplicationID, JobApplication jobApplication);

    public List<JobApplication> getAppliedJobs(String email);

}
