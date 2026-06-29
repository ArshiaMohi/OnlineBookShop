package com.example.project.service;

import com.example.project.dto.LoginRequest;
import com.example.project.dto.LoginResponse;

public interface AuthenticationService{
    LoginResponse login(LoginRequest request);
}
