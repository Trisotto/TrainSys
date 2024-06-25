package com.trainsys.trainsys_application.repository;

import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.user = :user AND s.isDeleted = false")
    Integer countByUser(UserEntity user);

    @Query("SELECT COUNT(s)>0 FROM StudentEntity s WHERE s.email = :email AND s.isDeleted = false")
    boolean existsByEmail(String email);

    @Query("SELECT COUNT(s)>0 FROM StudentEntity s WHERE s.cpf = :cpf AND s.isDeleted = false")
    boolean existsByCpf(String cpf);

    @Query("SELECT s FROM StudentEntity s WHERE s.user = :user AND s.isDeleted = false ORDER BY s.name")
    List<StudentEntity> findByUserOrderByName(UserEntity user);

    @Query("SELECT s FROM StudentEntity s WHERE s.user = :user AND (s.name LIKE %:name% OR s.cpf LIKE %:cpf% OR s.email LIKE %:email%) AND s.isDeleted = false ORDER BY s.name")
    List<StudentEntity> findByUserAndNameOrCpfOrEmailOrderByName(UserEntity user, String name, String cpf, String email);

    @Query("SELECT s FROM StudentEntity s WHERE s.id = :id AND s.isDeleted = false")
    Optional<StudentEntity> findById(Long id);
}
