package com.example.project.service;

import com.example.project.dto.LoginRequest;
import com.example.project.dto.LoginResponse;
import com.example.project.exception.UserNotFoundException;
import com.example.project.model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationServiceImpl implements AuthenticationService{

    private final PasswordEncoder passwordEncoder;

    private final ApplicationUserRepository applicationUserRepository;

    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder, ApplicationUserRepository applicationUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public LoginResponse login(LoginRequest request){
        ApplicationUser user = applicationUserRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Wrong password");
        }
        return new LoginResponse("LOGIN_SUCCESS");
    }


}
