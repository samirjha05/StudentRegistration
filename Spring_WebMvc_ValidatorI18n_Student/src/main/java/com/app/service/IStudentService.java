package com.app.service;

import java.util.List;

import com.app.model.Student;

public interface IStudentService {

	public Integer save(Student student);
	public void update(Student student);
	public void deleteById(Integer studId);
	public Student getById(Integer studId);
	public List<Student> getAll();
}
