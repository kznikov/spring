package com.project.medicalrecord.web.view.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PatientsViewModel {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private boolean isActive;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String pin;

}
