package com.fifth.spring.model;

public class UserModel {
    
    private int userId;  // ✅ Follow Java naming conventions
    private String username;
    private String password;

    
    public UserModel() {
    }

    
    public UserModel(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

   
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

  
}
