package com.project.medicalrecord.web.api;

import com.project.medicalrecord.dto.UpdateUserDTO;
import com.project.medicalrecord.dto.UserDTO;
import com.project.medicalrecord.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminApiController {

    private final UserService userService;

    private final ModelMapper modelMapper;



}
