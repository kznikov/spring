package com.project.medicalrecord.data.repository;

import com.project.medicalrecord.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndIsActive(String email, Boolean isActive);

    User findById(UUID id);
}
