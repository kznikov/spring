package com.project.medicalrecord.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "health_insurances")
public class HealthInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateFrom;

    private Date dateTo;


    private boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
