package com.example.project.exception;

public class DuplicateUsername extends RuntimeException{
    public DuplicateUsername(String message){
        super(message);
    }
}
