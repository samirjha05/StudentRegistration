package com.app.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.IStudentDao;
import com.app.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao{

	@Autowired
	private SessionFactory sf;
	
	public Integer save(Student student) {
		
		return (Integer)sf.getCurrentSession().save(student);
	}

	public void update(Student student) {
		sf.getCurrentSession().update(student);
		
	}

	public void deleteById(Integer studId) {
		sf.getCurrentSession().delete(studId);
		
	}

	public Student getById(Integer studId) {
		
		return sf.getCurrentSession().get(Student.class, studId);
	}

	public List<Student> getAll() {
		
		return sf.getCurrentSession().createQuery(Student.class.getName()).list();
	}

}
