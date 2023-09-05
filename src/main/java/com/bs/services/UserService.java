package com.bs.services;

import com.bs.models.User;

public interface UserService {
	
	public User registerUser(User u);
	
	public User loginUser(String email, String password);

	public User editUser(String email, User newU);
}
