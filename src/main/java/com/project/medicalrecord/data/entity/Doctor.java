package com.project.medicalrecord.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Doctor extends User {

    @Column(nullable = false)
    @ColumnDefault("true")
    private boolean isGp;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties("doctor")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties("doctor")
    private List<Treatment> treatments;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties("doctor")
    private List<Patient> patients;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "doctor_specialties",
            joinColumns = {@JoinColumn(name = "doctor_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialty_id", referencedColumnName = "id")})
    private List<MedicalSpecialty> specialties = new ArrayList<>();


}
