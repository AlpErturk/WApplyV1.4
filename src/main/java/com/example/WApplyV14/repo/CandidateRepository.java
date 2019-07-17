package com.example.WApplyV14.repo;
import com.example.WApplyV14.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

    Candidate findByEmail(String email);

    List<Candidate> findAllBy();
}
