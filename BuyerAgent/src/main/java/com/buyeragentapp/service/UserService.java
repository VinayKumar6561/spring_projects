package com.buyeragentapp.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.buyeragentapp.model.User;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void registerUser(User user) {
        // Insert User Data
        String userSql = "INSERT INTO users (first_name, last_name, email, password, contact) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(userSql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getContact());

        // Get User ID
        String userIdSql = "SELECT id FROM users WHERE email = ?";
        Integer userId = jdbcTemplate.queryForObject(userIdSql, Integer.class, user.getEmail());

        if (userId == null) throw new RuntimeException("User ID retrieval failed!");

        // Get Role ID
        String roleIdSql = "SELECT role_id FROM roles WHERE role_name = ?";
        Integer roleId = null;
        try {
            roleId = jdbcTemplate.queryForObject(roleIdSql, Integer.class, user.getRole());
        } catch (EmptyResultDataAccessException e) {
            // Role might not exist, proceed to insert
        }

        // If Role Doesn't Exist, Insert It
        if (roleId == null) {
            String insertRoleSql = "INSERT INTO roles (role_name) VALUES (?)";
            jdbcTemplate.update(insertRoleSql, user.getRole());

            // Retrieve the newly inserted role_id
            roleId = jdbcTemplate.queryForObject(roleIdSql, Integer.class, user.getRole());
            if (roleId == null) throw new RuntimeException("Role ID retrieval failed!");
        }

        // Insert into Role Lookup Table
        String lookupSql = "INSERT INTO role_lookup (user_id, role_id) VALUES (?, ?)";
        jdbcTemplate.update(lookupSql, userId, roleId);
    }

    public Map<String, Object> loginUser(String email, String password) {
        String sql = "SELECT u.id AS user_id, r.role_name FROM users u " +
                     "JOIN role_lookup rl ON u.id = rl.user_id " +
                     "JOIN roles r ON rl.role_id = r.role_id " +
                     "WHERE u.email = ? AND u.password = ?";

        try {
            return jdbcTemplate.queryForMap(sql, email, password); // Fetch both user_id and role_name
        } catch (EmptyResultDataAccessException e) {
            return null;  // Return null if credentials are incorrect
        }
    }
}
