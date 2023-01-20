package com.project.medicalrecord.web.view.controllers;


import lombok.AllArgsConstructor;
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
        return "user/dashboard/index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/auth/login";
    }

}
