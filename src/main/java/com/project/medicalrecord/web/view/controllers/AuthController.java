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

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class AuthController {



    @GetMapping("")
    public String home(Model model, Authentication authentication) {

        model.addAttribute("email", authentication.getName());

      /*  User user = new User();
        user.setFirstName("Krasimir");
        user.setLastName("Krasimir");
        user.setEmail("asd");
        user.setUpdatedAt(new Timestamp((new Date()).getTime()));
        user.setCreatedAt(new Timestamp((new Date()).getTime()));
        // encrypt the password using spring security
        user.setPassword("$2a$10$ffs2WPKAwG6AHMYP1yNo4uQTRtO0xu9BEDPZDV302UTvlUTwDGSGi");


        userRepository.save(user);
    */

        return "user/dashboard/index";
    }

    @GetMapping("/login")
    public String loginForm() {

        return "user/auth/login";
    }

}
