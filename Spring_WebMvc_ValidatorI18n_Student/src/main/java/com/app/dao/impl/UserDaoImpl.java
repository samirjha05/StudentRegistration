package com.app.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao{

	@Autowired
	private SessionFactory sf;
	@Override
	public User findByUserEmail(String username) {
		String hql="from "+User.class.getName()+" where userEmail=:email";
		return (User)sf.getCurrentSession().createQuery(hql).setParameter("email", username).uniqueResult();
	}

	@Override
	public void saveUser(User user) {
		sf.getCurrentSession().save(user);
		
	}

}
