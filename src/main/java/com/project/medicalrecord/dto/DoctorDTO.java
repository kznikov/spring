package com.project.medicalrecord.dto;


import com.project.medicalrecord.data.entity.Appointment;
import com.project.medicalrecord.data.entity.MedicalSpecialty;
import com.project.medicalrecord.data.entity.Patient;
import com.project.medicalrecord.data.entity.Treatment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDTO {
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private boolean isActive;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private boolean isGp;


    private List<Appointment> appointments;


    private List<Treatment> treatments;


    private List<Patient> patients;


    private List<MedicalSpecialty> specialties = new ArrayList<>();

}
