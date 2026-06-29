package com.example.project.service;

import com.example.project.dto.LoginRequest;
import com.example.project.dto.LoginResponse;
import com.example.project.dto.RegisterRequest;
import com.example.project.model.ApplicationUser;

public interface AuthenticationService{
    LoginResponse login(LoginRequest request);

    ApplicationUser register(RegisterRequest request);
}
