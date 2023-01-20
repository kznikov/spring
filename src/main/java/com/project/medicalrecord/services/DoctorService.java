package com.project.medicalrecord.services;

import com.project.medicalrecord.dto.PatientDTO;

import java.util.List;

public interface DoctorService {

    List<PatientDTO> getAllPatientsByDoctorEmail(String email);
}
