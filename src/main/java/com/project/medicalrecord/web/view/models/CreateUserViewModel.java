package com.project.medicalrecord.web.view.models;

import com.project.medicalrecord.data.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class CreateUserViewModel {

    private UUID id;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Should be a valid email")
    private String email;

    @Size(min = 6, message = "Should be greater than or equal to 7 characters")
    private String password;

    //TODO Currently password confirmation does not work
    @Size(min = 6, message = "Should be greater than or equal to 7 characters")
    private String passwordConfirm;

    private boolean isActive;

    @NotEmpty(message = "Select at least one role")
    private List<Role> roles;

}
