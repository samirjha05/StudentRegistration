package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;
import com.app.model.Student;
import com.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentDao dao;
	@Transactional
	public Integer save(Student student) {
		
		return dao.save(student);
	}
	@Transactional
	public void update(Student student) {
		dao.update(student);
		
	}
	@Transactional
	public void deleteById(Integer studId) {
		dao.deleteById(studId);
		
	}
	@Transactional(readOnly=true)
	public Student getById(Integer studId) {
		
		return dao.getById(studId);
	}
	@Transactional(readOnly=true)
	public List<Student> getAll() {
		
		return dao.getAll();
	}

}
