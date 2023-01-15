package com.project.medicalrecord.web.view.controllers;


import com.project.medicalrecord.dto.UserDTO;
import com.project.medicalrecord.web.view.models.UserViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class UserController {


    private final ModelMapper modelMapper;


    @GetMapping("")
    public String home(Model model, Authentication authentication) {

        model.addAttribute("email", authentication.getName());

        return "user/dashboard/index";
    }

    @GetMapping("/login")
    public String loginForm() {

        return "user/auth/login";
    }

    private UserViewModel convertToUserViewModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserViewModel.class);
    }
}
