package com.project.medicalrecord.web.view.controllers;

import com.project.medicalrecord.dto.PatientDTO;
import com.project.medicalrecord.services.DoctorService;
import com.project.medicalrecord.web.view.models.CreatePatientViewModel;
import com.project.medicalrecord.web.view.models.PatientsViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {


    private final DoctorService doctorService;

    private final ModelMapper modelMapper;

    @GetMapping("/patient/create")
    public String createPatient(Model model) {

        model.addAttribute("patient", new CreatePatientViewModel());

        return "doctor/patient/create";
    }


    @GetMapping("/patient/list")
    public String listPatients(Model model, Authentication auth) {

        final List<PatientsViewModel> patients = doctorService.getAllPatientsByDoctorEmail(auth.getName())
                .stream()
                .map(this::convertToPatientViewModel)
                .collect(Collectors.toList());

        model.addAttribute("patients", patients);

        System.out.println(patients.toArray());

        return "doctor/patient/list";
    }


    private PatientsViewModel convertToPatientViewModel(PatientDTO patientDTO) {
        return modelMapper.map(patientDTO, PatientsViewModel.class);
    }

}
