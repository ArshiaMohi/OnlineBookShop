package com.example.project.controller;

import com.example.project.dto.LoginRequest;
import com.example.project.dto.LoginResponse;
import com.example.project.dto.RegisterRequest;
import com.example.project.model.ApplicationUser;
import com.example.project.service.ApplicationUserService;
import com.example.project.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    private final ApplicationUserService applicationUserService;

    public AuthenticationController(AuthenticationService authenticationService, ApplicationUserService applicationUserService) {
        this.authenticationService = authenticationService;
        this.applicationUserService = applicationUserService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }

    @PostMapping("/register")
    public ApplicationUser register(@Valid @RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }
}
