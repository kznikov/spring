package com.project.medicalrecord.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}
