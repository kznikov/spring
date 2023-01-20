package com.project.medicalrecord.data.repository;

import com.project.medicalrecord.data.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByEmail(String email);

}
