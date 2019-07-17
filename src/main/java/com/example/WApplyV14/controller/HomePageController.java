package com.example.WApplyV14.controller;

import com.example.WApplyV14.model.Candidate;
import com.example.WApplyV14.model.JobApplication;
import com.example.WApplyV14.model.JobNotice;
import com.example.WApplyV14.repo.CandidateRepository;
import com.example.WApplyV14.repo.JobApplicationRepository;
import com.example.WApplyV14.repo.JobNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class HomePageController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private JobNoticeRepository jobNoticeRepository;

    @GetMapping(path = "/home")
    public String getHomePage(){
        Candidate c1 = new Candidate();
        c1.setEmail("alperturkae@gmail.com");
        c1.setUsername("Alp Erturk");
        c1.setPassword("password");
        candidateRepository.save(c1);
        System.out.println("candidate added");

        JobNotice jn1 = new JobNotice();
        jn1.setJobNoticeID(1);
        jn1.setActive(true);
        jn1.setDescription("adawdawdad");
        jn1.setFutureStatus(false);
        jn1.setQualifications("özellikler");
        jn1.setFutureStatusChangeOfNotice(null);
        jn1.setRelatedAdmin("admin");
        jn1.setApplications(null);
        jn1.setRelatedCompany("obss");
        jobNoticeRepository.save(jn1);
        System.out.println("JobNotice added");

        /*JobApplication ja1 = new JobApplication();
       // ja1.setJobNoticeID(11);
        //ja1.setCandidateEmail("alperturkae@gmail.com");
        ja1.setStatus(JobApplication.applicationStatus.ON_PROCESS);
        jobApplicationRepository.save(ja1);
        System.out.println("JobApplication added");*/
        return "home";
    }

    @GetMapping(path = "/products")
    public String getProducts(Model model){
        model.addAttribute("products", Arrays.asList("iPad","iPhone","iPod"));
        return "products";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "/";
    }
}