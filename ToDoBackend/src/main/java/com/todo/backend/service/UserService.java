package com.todo.backend.service;

import com.todo.backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Register User
    public String registerUser(UserModel user) {
        String sql = "INSERT INTO users (firstname, lastname, email, username, password) VALUES (?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, user.getFirstname(), user.getLastname(), user.getEmail(), user.getUsername(), user.getPassword());
        return result > 0 ? "User Registered Successfully" : "Registration Failed";
    }
    
    public List<UserModel> loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        return jdbcTemplate.query(sql, (rs, row) -> new UserModel(
            rs.getInt("user_id"),
            rs.getString("firstname"),
            rs.getString("lastname"),
            rs.getString("email"),
            rs.getString("username"),
            rs.getString("password")
        ), username, password);
    }


}
