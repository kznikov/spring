package com.project.medicalrecord.services;


import com.project.medicalrecord.data.entity.User;
import com.project.medicalrecord.dto.RoleDTO;
import com.project.medicalrecord.dto.UpdateUserDTO;
import com.project.medicalrecord.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface RoleService {

    List<RoleDTO> getAllRoles();
}
