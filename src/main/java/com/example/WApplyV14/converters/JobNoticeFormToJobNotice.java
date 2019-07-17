package com.example.WApplyV14.converters;


import com.example.WApplyV14.commands.JobNoticeForm;
import com.example.WApplyV14.model.JobNotice;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JobNoticeFormToJobNotice implements Converter<JobNoticeForm, JobNotice> {

        @Override
        public JobNotice convert(JobNoticeForm jobNoticeForm) {
            JobNotice jobNotice = new JobNotice();

            if (jobNoticeForm.getJobNoticeID() != -1  && !StringUtils.isEmpty(jobNoticeForm.getJobNoticeID())) {
                jobNotice.setJobNoticeID(jobNoticeForm.getJobNoticeID());
            }

           // jobNotice.setApplications(jobNoticeForm.getCurrentApplications());
            jobNotice.setActive(jobNoticeForm.isActive());
            jobNotice.setDescription(jobNoticeForm.getDescription());
            jobNotice.setRelatedCompany(jobNoticeForm.getRelatedCompany());
            jobNotice.setQualifications(jobNoticeForm.getQualifications());
            jobNotice.setFutureStatus(jobNoticeForm.getFutureStatus());
            jobNotice.setRelatedAdmin(jobNoticeForm.getRelatedAdmin());

            return jobNotice;
        }

}
