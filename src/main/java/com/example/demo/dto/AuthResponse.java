package com.example.demo.dto;

public class AuthResponse {
    private UserDTO user;
    private String token;
    
    // Constructors
    public AuthResponse() {}
    
    public AuthResponse(UserDTO user, String token) {
        this.user = user;
        this.token = token;
    }
    
    // Getters and Setters
    public UserDTO getUser() {
        return user;
    }
    
    public void setUser(UserDTO user) {
        this.user = user;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
}