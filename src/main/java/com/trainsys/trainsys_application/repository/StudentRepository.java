package com.trainsys.trainsys_application.repository;

import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Integer countByUser(UserEntity user);
}
