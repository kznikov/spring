package com.project.medicalrecord.dto;


import com.project.medicalrecord.data.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PatientDTO {
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private boolean isActive;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    // Personal Identification Number
    @Column(nullable = false)
    private String pin;

    private List<HealthInsurance> insurances;

    private List<Appointment> appointments;

    private List<Treatment> treatments;

    private List<SickLeave> leaves;

    private Doctor doctor;

}
