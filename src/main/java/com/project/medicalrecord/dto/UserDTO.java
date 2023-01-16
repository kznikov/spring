package com.project.medicalrecord.dto;


import com.project.medicalrecord.data.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean isActive;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private List<Role> roles;

}
