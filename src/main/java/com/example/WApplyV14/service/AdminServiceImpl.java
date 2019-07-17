package com.example.WApplyV14.service;


import com.example.WApplyV14.commands.JobNoticeForm;
import com.example.WApplyV14.converters.JobNoticeFormToJobNotice;
import com.example.WApplyV14.model.Candidate;
import com.example.WApplyV14.model.JobApplication;
import com.example.WApplyV14.model.JobNotice;
import com.example.WApplyV14.repo.CandidateRepository;
import com.example.WApplyV14.repo.JobApplicationRepository;
import com.example.WApplyV14.repo.JobNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AdminServiceImpl implements AdminService {

    private CandidateRepository candidateRepository;
    private JobNoticeRepository jobNoticeRepository;
    private JobApplicationRepository jobApplicationRepository;
    private JobNoticeFormToJobNotice jobNoticeFormToJobNotice;


    @Autowired
    public AdminServiceImpl(CandidateRepository candidateRepository, JobNoticeRepository jobNoticeRepository, JobApplicationRepository jobApplicationRepository, JobNoticeFormToJobNotice jobNoticeFormToJobNotice) {
        this.candidateRepository = candidateRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobNoticeRepository = jobNoticeRepository;
        this.jobNoticeFormToJobNotice = jobNoticeFormToJobNotice;

    }

    @Override
    public List<Candidate> listAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        candidateRepository.findAll().forEach(candidates::add); //fun with Java 8
        return candidates;
    }

    @Override
    public List<JobApplication> listAllApplications() {
        List<JobApplication> jobApplications = new ArrayList<>();
        jobApplicationRepository.findAll().forEach(jobApplications::add); //fun with Java 8
        return jobApplications;
    }

    @Override
    public List<JobNotice> listAllJobNotices() {
        List<JobNotice> jobNotices = new ArrayList<>();
        jobNoticeRepository.findAll().forEach(jobNotices::add); //fun with Java 8
        return jobNotices;
    }

    @Override
    public JobNotice createOrUpdateJobNotice(JobNotice jobNotice) {
        jobNoticeRepository.save(jobNotice);
        return jobNotice;
    }

    /*@Override
    public List<Candidate> seeAppliedCandidates(JobNotice jobNotice) {
        List<JobApplication> currentApplications = jobNotice.getApplications();
        List<Candidate> resultList = null;
        Candidate currentCandidate;

        for(int i = 0; i < currentApplications.size(); i++){
            String email = currentApplications.get(i).getCandidateEmail();
            currentCandidate = candidateRepository.findByEmail(email);
            resultList.add(currentCandidate);
        }

        return resultList;
    }*/

   /* @Override
    public List<JobApplication> seeOtherApplicationsOfCandidate(Candidate candidate) {
        return candidate.getAppliedJobs();
    }*/

    @Override
    public void deleteJobNotice(int jobNoticeID) {
        jobNoticeRepository.deleteById(jobNoticeID);
    }

    @Override
    public void changeStatusOfJobApplication(JobApplication jobApplication, JobApplication.applicationStatus status) {
        jobApplication.setStatus(status);
        jobApplicationRepository.save(jobApplication);
    }

    @Override
    public void sendEmailToCandidate(JobApplication jobApplication) {
        //IMPLEMENT IT LATER
    }

    @Override
    public Set<JobApplication> filteredApplications(JobNotice jobNotice, JobApplication.applicationStatus status) {
        Set<JobApplication> resultList = null;
        Set<JobApplication> currentApplications = jobNotice.getApplications();

        Iterator<JobApplication> itr = currentApplications.iterator();

        while(itr.hasNext()){
            if(itr.next().getStatus() == status){ //== yerine equals kullanmak gerekeblir dikkat
                resultList.add(itr.next());
            }
        }

        return  resultList;
    }

    @Override
    public void putCandidateToBlackList(Candidate candidate, String description, String email) {
        candidate.setCanMakeJobApplication(false);
        candidateRepository.save(candidate);
    }

    @Override
    public JobNotice saveOrUpdateJobNoticeForm(JobNoticeForm jobNoticeForm) {
        JobNotice savedJobNotice = createOrUpdateJobNotice(jobNoticeFormToJobNotice.convert(jobNoticeForm));

        System.out.println("Saved Job Notice  ID: " + savedJobNotice.getJobNoticeID());
        return savedJobNotice;
    }

    @Override
    public JobNotice getByJobNoticeID(int jobNoticeID) {
        return jobNoticeRepository.findByJobNoticeID(jobNoticeID);
    }

    @Override
    public JobApplication getByJobApplicationID(int jobApplicationID) {
        return jobApplicationRepository.findByJobApplicationID(jobApplicationID);
    }

}
