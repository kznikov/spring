package com.project.medicalrecord.dto;

import com.project.medicalrecord.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO {

    private Long id;

    private String name;

    private List<User> users;

}
