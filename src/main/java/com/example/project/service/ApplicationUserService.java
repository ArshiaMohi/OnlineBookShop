package com.example.project.service;

import com.example.project.model.ApplicationUser;

import java.util.List;

public interface ApplicationUserService {

    void save(ApplicationUser user);

    void delete(ApplicationUser user);

    void update(ApplicationUser user);

    ApplicationUser findByUsername(String username);

    ApplicationUser findById(int id);

    List<ApplicationUser> findAll();
}
