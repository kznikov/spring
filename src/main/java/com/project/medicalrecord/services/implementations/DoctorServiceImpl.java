package com.project.medicalrecord.services.implementations;

import com.project.medicalrecord.data.repository.DoctorRepository;
import com.project.medicalrecord.dto.DoctorPatientsDTO;
import com.project.medicalrecord.dto.PatientDTO;
import com.project.medicalrecord.services.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    private final ModelMapper modelMapper;


    @Override
    public List<PatientDTO> getAllPatientsByDoctorEmail(String email) {
        DoctorPatientsDTO doctor = modelMapper.map(doctorRepository.findByEmail(email), DoctorPatientsDTO.class);
        return doctor.getPatients();
    }

}
