package com.project.medicalrecord.data.repository;

import com.project.medicalrecord.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}