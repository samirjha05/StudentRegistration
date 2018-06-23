package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao dao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public User findUserByEmail(String email) {
		
		return dao.findByUserEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setUserPwd(encoder.encode(user.getUserPwd()));
		dao.saveUser(user);
		
	}

}
