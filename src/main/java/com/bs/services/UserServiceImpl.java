package com.bs.services;

import com.bs.daos.UserDAO;
import com.bs.models.User;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	

	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	@Override
	public User registerUser(User u) {
		
		return this.userDAO.registerUser(u);
	}

	@Override
	public User loginUser(String email, String password) {
		
		return this.userDAO.loginUser(email,password);
	}
	
	@Override
	public User editUser(String email, User u) {
		
		return this.userDAO.editUser(email,u);
	}

}
