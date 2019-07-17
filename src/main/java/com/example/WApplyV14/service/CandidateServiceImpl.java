package com.example.WApplyV14.service;


import com.example.WApplyV14.model.Candidate;
import com.example.WApplyV14.model.JobApplication;
import com.example.WApplyV14.model.JobNotice;
import com.example.WApplyV14.repo.CandidateRepository;
import com.example.WApplyV14.repo.JobApplicationRepository;
import com.example.WApplyV14.repo.JobNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository candidateRepository;
    private JobNoticeRepository jobNoticeRepository;
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository, JobNoticeRepository jobNoticeRepository, JobApplicationRepository jobApplicationRepository) {
        this.candidateRepository = candidateRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobNoticeRepository = jobNoticeRepository;

    }

    @Override
    public Candidate createOrUpdateCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
        return candidate;
    }


    @Override
    public void makeJobApplication(String email, int jobNoticeID, int jobApplicationID, JobApplication jobApplication) {
        jobApplicationRepository.save(jobApplication);

        //get candidate with given email and her applications and add new one
        Candidate currentCandidate = candidateRepository.findByEmail(email);
        currentCandidate.getAppliedJobs().add(jobApplication);
        candidateRepository.save(currentCandidate);

        //get all applications under an job notice and add new one
        JobNotice currentJobNotice = jobNoticeRepository.findByJobNoticeID(jobNoticeID);
        currentJobNotice.getApplications().add(jobApplication);
        jobNoticeRepository.save(currentJobNotice);
    }

    @Override
    public List<JobApplication> getAppliedJobs(String email) {
        return jobApplicationRepository.findAllBy();
    }

}
