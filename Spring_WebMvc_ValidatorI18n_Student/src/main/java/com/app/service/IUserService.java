package com.app.service;

import com.app.model.User;

public interface IUserService {
	
	public User findUserByEmail(String email);
	public void saveUser(User user);

}
