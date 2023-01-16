package com.project.medicalrecord.web.view.controllers;

import com.project.medicalrecord.dto.UserDTO;
import com.project.medicalrecord.services.UserService;
import com.project.medicalrecord.web.view.models.UserViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;

    private final ModelMapper modelMapper;


    @GetMapping("/user/create")
    public String createUser(Model model) {

        return "admin/user/create";
    }

    @GetMapping("/user/list")
    public String listUsers(Model model) {

        final List<UserViewModel> users = userService.getAllUsers()
                .stream()
                .map(this::convertToUserViewModel)
                .collect(Collectors.toList());

        model.addAttribute("users", users);

        //System.out.println("1111111111"+users.toArray().toString());

        return "admin/user/list";
    }

    @GetMapping("/user/edit")
    public String editUser(Model model) {

        return "admin/user/edit";
    }

    @GetMapping("/role/list")
    public String listRoles(Model model) {

        return "admin/role/list";
    }

    private UserViewModel convertToUserViewModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserViewModel.class);
    }

}
