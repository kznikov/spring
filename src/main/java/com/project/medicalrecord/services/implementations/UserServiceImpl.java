package com.project.medicalrecord.services.implementations;


import com.project.medicalrecord.data.entity.User;
import com.project.medicalrecord.data.repository.RoleRepository;
import com.project.medicalrecord.data.repository.UserRepository;
import com.project.medicalrecord.dto.CreateUserDTO;
import com.project.medicalrecord.dto.UpdateUserDTO;
import com.project.medicalrecord.dto.UserDTO;
import com.project.medicalrecord.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    @Override
    public User create(CreateUserDTO createUserDTO) {
        return userRepository.save(modelMapper.map(createUserDTO, User.class));
    }

    @Override
    public User updateUser(UUID id, UpdateUserDTO updateUserDTO) {
        User user = modelMapper.map(updateUserDTO, User.class);
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public User findByEmailAndActive(String email) {
        return userRepository.findByEmailAndIsActive(email, true);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(UUID id) {
        return modelMapper.map(userRepository.findById(id), UserDTO.class);
    }

    @Override
    public Page<UserDTO> getUsersPagination(Pageable pageable) {
        List<UserDTO> userList = userRepository.findAll()
                .stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();
        int firstUserNumber = page * size;

        List<UserDTO> userPageList;

        if (userList.size() < firstUserNumber) {
            userPageList = Collections.emptyList();
        } else {
            int toIndex = Math.min(firstUserNumber + size, userList.size());
            userPageList = userList.subList(firstUserNumber, toIndex);
        }

        Page<UserDTO> pageOfUsers
                = new PageImpl<UserDTO>(userPageList, PageRequest.of(page, size), userList.size());

        return pageOfUsers;

    }


    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

}
