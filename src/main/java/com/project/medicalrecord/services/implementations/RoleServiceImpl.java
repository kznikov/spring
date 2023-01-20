package com.project.medicalrecord.services.implementations;

import com.project.medicalrecord.data.entity.Role;
import com.project.medicalrecord.data.entity.User;
import com.project.medicalrecord.data.repository.RoleRepository;
import com.project.medicalrecord.data.repository.UserRepository;
import com.project.medicalrecord.dto.RoleDTO;
import com.project.medicalrecord.dto.UserDTO;
import com.project.medicalrecord.services.RoleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(this::convertToRoleDTO)
                .collect(Collectors.toList());
    }

    private RoleDTO convertToRoleDTO(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }

}
