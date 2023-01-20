package com.project.medicalrecord.web.view.controllers;

import com.project.medicalrecord.data.entity.User;
import com.project.medicalrecord.dto.CreateUserDTO;
import com.project.medicalrecord.dto.UpdateUserDTO;
import com.project.medicalrecord.dto.UserDTO;
import com.project.medicalrecord.services.RoleService;
import com.project.medicalrecord.services.UserService;
import com.project.medicalrecord.web.view.models.CreateUserViewModel;
import com.project.medicalrecord.web.view.models.UpdateUserViewModel;
import com.project.medicalrecord.web.view.models.UserViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;
    private final RoleService roleService;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;


    @GetMapping("/user/create")
    public String createUser(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("userId", UUID.randomUUID());
        model.addAttribute("user", new CreateUserViewModel());

        return "admin/user/create";
    }

    @PostMapping("/user/add")
    public String addUser(Model model, @Valid @ModelAttribute("user") CreateUserViewModel user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleService.getAllRoles());
            model.addAttribute("userId", UUID.randomUUID());
            return "admin/user/create";
        }

        User userExists = userService.findByEmailAndActive(user.getEmail());

        if (userExists != null) {
            return "redirect:/admin/user/list?email";
        }

        user.setActive(true);

        // TODO check passwords matching
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.create(modelMapper.map(user, CreateUserDTO.class));
        return "redirect:/admin/user/list?success";
    }


    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable UUID id, Model model) {

        model.addAttribute("roles", roleService.getAllRoles());

        model.addAttribute("user", modelMapper.map(userService.getUserById(id), UpdateUserViewModel.class));

        return "admin/user/edit";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable UUID id, Model model, @Valid @ModelAttribute("user") UpdateUserViewModel user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleService.getAllRoles());
            return "admin/user/edit";
        }

        User userExists = userService.findByEmailAndActive(user.getEmail());

        // If the email is already used
        if (userExists.getId() != id) {
            return "redirect:/admin/user/edit/" + id + "?email";
        }

        // TODO check passwords matching
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.create(modelMapper.map(user, CreateUserDTO.class));
        return "redirect:/admin/user/edit/" + id + "?success";
    }


    @GetMapping("/user/changeStatus/{id}/{status}")
    public String changeUserStatus(@PathVariable UUID id, @PathVariable boolean status) {

        UserDTO user = userService.getUserById(id);

        user.setActive(status);
        userService.updateUser(id, modelMapper.map(user, UpdateUserDTO.class));

        return "redirect:/admin/user/list";
    }

    @GetMapping("/user/list")
    public String listUsers(Model model
            , @RequestParam("page") Optional<Integer> page
            , @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Type pageType = new TypeToken<Page<UserViewModel>>() {
        }.getType();
        final Page<UserViewModel> listOfUsers =
                modelMapper.map(userService.getUsersPagination(PageRequest.of(currentPage - 1, pageSize)), pageType);

        model.addAttribute("listUsers", listOfUsers);

        int totalPages = listOfUsers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "admin/user/list";
    }


    @GetMapping("/role/list")
    public String listRoles(Model model) {

        return "admin/role/list";
    }

    private UserViewModel convertToUserViewModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserViewModel.class);
    }

}
