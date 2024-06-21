package com.trainsys.trainsys_application.repository;

import com.trainsys.trainsys_application.entity.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long> {
}
