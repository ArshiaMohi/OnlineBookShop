package com.example.project.dto;

import com.example.project.model.ApplicationUser;

public class ApplicationUserSaveDto {
    private int id;
    private String username;
    private String password;
    private String email;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ApplicationUser convert() {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setId(this.id);
        applicationUser.setAddress(this.address);
        applicationUser.setEmail(this.email);
        applicationUser.setUsername(this.username);
        applicationUser.setPassword(this.password);
        return applicationUser;
    }
}
