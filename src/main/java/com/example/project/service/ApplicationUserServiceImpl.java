package com.example.project.service;

import com.example.project.config.SecurityConfig;
import com.example.project.model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    private final SecurityConfig securityConfig;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository, SecurityConfig securityConfig) {
        this.applicationUserRepository = applicationUserRepository;
        this.securityConfig = securityConfig;
    }


    @Override
    public void save(ApplicationUser user) {
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    @Override
    public void delete(ApplicationUser user) {
        applicationUserRepository.delete(user);
    }

    @Override
    public void update(ApplicationUser user) {
        applicationUserRepository.save(user);
    }

    @Override
    public ApplicationUser findByUsernameAndPassword(String username, String password) {
        return applicationUserRepository.findByUsernameAndPassword(username, password);
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
