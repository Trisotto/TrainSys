package com.trainsys.trainsys_application.repository;

import com.trainsys.trainsys_application.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
    PlanEntity findByName(String name);
}
