package com.example.WApplyV14.converters;


import com.example.WApplyV14.commands.JobNoticeForm;
import com.example.WApplyV14.model.JobNotice;
import org.springframework.core.convert.converter.Converter;

public class JobNoticeToJobNoticeForm implements Converter<JobNotice, JobNoticeForm> {

    @Override
    public JobNoticeForm convert(JobNotice jobNotice) {
        JobNoticeForm jobNoticeForm = new JobNoticeForm();

        jobNoticeForm.setJobNoticeID(jobNotice.getJobNoticeID());
        jobNoticeForm.setCurrentApplications(jobNoticeForm.getCurrentApplications());
        jobNoticeForm.setActive(jobNotice.getActive());
        jobNoticeForm.setDescription(jobNotice.getDescription());
        jobNoticeForm.setRelatedCompany(jobNotice.getRelatedCompany());
        jobNoticeForm.setQualifications(jobNotice.getQualifications());
        jobNoticeForm.setFutureStatus(jobNotice.getFutureStatus());
        jobNoticeForm.setRelatedAdmin(jobNotice.getRelatedAdmin());

        return jobNoticeForm;
    }

}
