package com.example.project.controller;

import com.example.project.model.ApplicationUser;
import com.example.project.service.ApplicationUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/{id}")
    public ApplicationUser findById(@PathVariable int id) {
        return applicationUserService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        ApplicationUser applicationUser = applicationUserService.findById(id);
        applicationUserService.delete(applicationUser);
    }

    @GetMapping()
    public List<ApplicationUser> findAll() {
        return applicationUserService.findAll();
    }

}
