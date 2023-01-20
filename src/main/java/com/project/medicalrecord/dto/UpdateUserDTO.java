package com.project.medicalrecord.dto;

import com.project.medicalrecord.data.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateUserDTO {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Timestamp createdAt;

    private boolean isActive;

    private List<Role> roles;
}
