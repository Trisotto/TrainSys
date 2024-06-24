package com.trainsys.trainsys_application.repository;

import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {
    Integer countByUser(UserEntity user);
}
