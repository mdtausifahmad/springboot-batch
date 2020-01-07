package com.batch.repo;

import com.batch.domain.DedWorkFlowResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DedWorkFlowResponseRepository extends JpaRepository<DedWorkFlowResponse, Long> {
    public Page<DedWorkFlowResponse> findByPickedIs(boolean picked,Pageable pageable);
}
