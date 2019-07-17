package com.example.WApplyV14.controller;

import com.example.WApplyV14.commands.JobNoticeForm;
import com.example.WApplyV14.converters.JobNoticeToJobNoticeForm;
import com.example.WApplyV14.model.JobNotice;
import com.example.WApplyV14.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public class JobApplicationController {
    private AdminService adminService;
    private JobNoticeToJobNoticeForm jobNoticeToJobNoticeForm;

    @Autowired
    public void setJobNoticeToJobNoticeForm(JobNoticeToJobNoticeForm jobNoticeToJobNoticeForm) {
        this.jobNoticeToJobNoticeForm = jobNoticeToJobNoticeForm;
    }

    @Autowired
    public void setAdminServiceService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/jobNotice/list";
    }

    @RequestMapping({"/jobNotice/list", "/jobNotice"})
    public String listJobNotices(Model model){
        model.addAttribute("jobNotices", adminService.listAllJobNotices());
        return "jobNotice/list";
    }

    @RequestMapping("/jobNotice/show/{jobNoticeID}")
    public String getJobNotice(@PathVariable int jobNoticeID, Model model){
        model.addAttribute("jobNotice", adminService.getByJobNoticeID(jobNoticeID));
        return "jobNotice/show";
    }

    @RequestMapping("jobNotice/edit/{jobNoticeID}")
    public String edit(@PathVariable int jobNoticeID, Model model){
        JobNotice jobNotice = adminService.getByJobNoticeID(jobNoticeID);
        JobNoticeForm jobNoticeForm = jobNoticeToJobNoticeForm.convert(jobNotice);

        model.addAttribute("jobNoticeForm", jobNoticeForm);
        return "jobNotice/jobNoticeForm";
    }

    @RequestMapping(value = "/jobNotice", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid JobNoticeForm jobNoticeForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "jobNotice/jobNoticeForm";
        }

        JobNotice jobNotice = adminService.saveOrUpdateJobNoticeForm(jobNoticeForm);
        JobNotice savedJobNotice = adminService.saveOrUpdateJobNoticeForm(jobNoticeForm);

        return "redirect:/jobNotice/show/" + savedJobNotice.getJobNoticeID();
    }

    @RequestMapping("/jobNotice/delete/{jobNoticeID}")
    public String delete(@PathVariable int jobNoticeID){
        adminService.deleteJobNotice(jobNoticeID);
        return "redirect:/jobNotice/list";
    }
}



