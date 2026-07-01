package com.example.project.service;


import com.example.project.dto.RegisterRequest;
import com.example.project.exception.DuplicateUsername;
import com.example.project.exception.UserNotFoundException;
import com.example.project.exception.UsernameNotFoundException;
import com.example.project.model.ApplicationUser;
import com.example.project.model.Role;
import com.example.project.repository.ApplicationUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void save(RegisterRequest request) {
        if (applicationUserRepository.findByUsername(request.getUsername()).isPresent()){
            throw new DuplicateUsername("Username already exists");
        }
        ApplicationUser user = new ApplicationUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        applicationUserRepository.save(user);
    }

    @Override
    public void delete(ApplicationUser user) {
        applicationUserRepository.delete(user);
    }

    @Override
    public void update(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    @Override
    public ApplicationUser findByUsername(String username) {
        return applicationUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    @Override
    public ApplicationUser findById(int id) {
        return applicationUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }
}
