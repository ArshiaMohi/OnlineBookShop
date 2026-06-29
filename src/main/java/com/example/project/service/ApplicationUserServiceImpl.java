package com.example.project.service;

import com.example.project.config.SecurityConfig;
import com.example.project.exception.UsernameNotFoundException;
import com.example.project.model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository, SecurityConfig securityConfig, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void save(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        return applicationUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }
}
