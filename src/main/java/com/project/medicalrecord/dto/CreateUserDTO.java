package com.project.medicalrecord.dto;

import com.project.medicalrecord.data.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateUserDTO {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;


    private String password;

    private boolean isActive;

    private List<Role> roles;

}
