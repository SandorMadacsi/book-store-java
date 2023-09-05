package com.bs.controllers;

import com.bs.models.User;
import com.bs.services.UserService;

public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	public User registerUser(User u) {
		
		return this.userService.registerUser(u);
	}

	
	public User loginUser(String email, String password) {
		
		return this.userService.loginUser(email,password);
	}
	
	public User editUser(String email, User u) {
		
		return this.userService.editUser(email,u);
	}

}
