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
@Table(name = "sick_leaves")
public class SickLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateFrom;

    private Date dateTo;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
