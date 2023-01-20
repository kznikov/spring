package com.project.medicalrecord.services;


import com.project.medicalrecord.data.entity.User;
import com.project.medicalrecord.dto.CreateUserDTO;
import com.project.medicalrecord.dto.UpdateUserDTO;
import com.project.medicalrecord.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User findByEmailAndActive(String email);

    Page<UserDTO> getUsersPagination(Pageable pageable);

    User updateUser(UUID id, UpdateUserDTO updateUserDTO);

    UserDTO getUserById(UUID id);

    User create(CreateUserDTO createSchoolDTO);

    List<UserDTO> getAllUsers();
}
