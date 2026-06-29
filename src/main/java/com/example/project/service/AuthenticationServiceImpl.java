package com.example.project.service;

import com.example.project.dto.LoginRequest;
import com.example.project.dto.LoginResponse;
import com.example.project.exception.UserNotFoundException;
import com.example.project.model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import com.example.project.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final PasswordEncoder passwordEncoder;

    private final ApplicationUserRepository applicationUserRepository;

    private final JwtService jwtService;

    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder, ApplicationUserRepository applicationUserRepository, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserRepository = applicationUserRepository;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request){
        ApplicationUser user = applicationUserRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Wrong password");
        }

        String token = jwtService.generateToken(user);
        return new LoginResponse(token);
    }


}
