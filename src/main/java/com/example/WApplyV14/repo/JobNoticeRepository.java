package com.example.WApplyV14.repo;

import com.example.WApplyV14.model.JobNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobNoticeRepository extends JpaRepository<JobNotice, Integer> {
    JobNotice findByJobNoticeID(int jobNoticeID);

    List<JobNotice> findAllBy();
}
