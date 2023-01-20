package com.project.medicalrecord.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorPatientsDTO {


    private List<PatientDTO> patients;


}
