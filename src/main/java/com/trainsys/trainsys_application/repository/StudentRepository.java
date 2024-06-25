package com.trainsys.trainsys_application.repository;

import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Integer countByUser(UserEntity user);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

    List<StudentEntity> findByUserOrderByName(UserEntity user);

    List<StudentEntity> findByUserAndNameOrCpfOrEmailOrderByName(UserEntity user, String name, String cpf, String email);
}
