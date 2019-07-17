package com.example.WApplyV14.repo;

import com.example.WApplyV14.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
    JobApplication findByJobApplicationID(int jobApplicationID);

    List<JobApplication> findAllBy();
}
