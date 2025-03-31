package com.fifth.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fifth.spring.model.UserModel;
import com.fifth.spring.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

	@Autowired
	UserService uService;
	
	@GetMapping("/first")
	public String fun1() {
		return uService.fun1();
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserModel uModel) {
		return uService.addUser(uModel);
	}
	
	@GetMapping("/displayUser")
	public List<UserModel> displayUser() {
		return uService.displayUser();
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody UserModel uModel) {
		return uService.loginUser(uModel);
	}
	
	
	
}
