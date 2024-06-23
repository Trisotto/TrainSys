package com.trainsys.trainsys_application.repository;

import com.trainsys.trainsys_application.entity.RoleEntity;
import com.trainsys.trainsys_application.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(RoleEnum name);
}
