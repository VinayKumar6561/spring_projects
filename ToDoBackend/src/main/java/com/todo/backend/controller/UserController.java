package com.todo.backend.controller;

import com.todo.backend.model.UserModel;
import com.todo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel user) {
        return userService.registerUser(user);
    }
    
    @PostMapping("/login")
    public UserModel loginUser(@RequestBody UserModel user) {
        List<UserModel> users = userService.loginUser(user.getUsername(), user.getPassword());
        return users.isEmpty() ? null : users.get(0);
    }
    
}
