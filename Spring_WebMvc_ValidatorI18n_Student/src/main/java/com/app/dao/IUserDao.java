package com.app.dao;

import com.app.model.User;

public interface IUserDao {

	public User findByUserEmail(String username);
	public void saveUser(User user);
}
