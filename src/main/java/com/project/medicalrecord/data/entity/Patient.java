package com.project.medicalrecord.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "user_id")
public class Patient extends User {

    // Personal Identification Number
    @Column(nullable = false)
    private String pin;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    private List<HealthInsurance> insurances;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    private List<Treatment> treatments;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    private List<SickLeave> leaves;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


}
