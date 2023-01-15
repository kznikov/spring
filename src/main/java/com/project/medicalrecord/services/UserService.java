package com.project.medicalrecord.services;


import com.project.medicalrecord.data.entity.User;
import com.project.medicalrecord.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDto);

    User findByEmail(String email);

    List<UserDTO> findAllUsers();
}