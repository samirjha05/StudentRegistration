package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student {
	@Id
	@Column(name="sid")
	@GeneratedValue(generator="studGenr")
	@GenericGenerator(name="studGenr",strategy="increment")
	private Integer studId;
	
	@Column(name="sname")
	private String studName;
	
	@Column(name="pwd")
	private String studPwd;
	
	@Column(name="gen")
	private String studGen;
	
	@Column(name="age")
	private Integer studAge;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="studcrs")
	@OrderColumn(name="pos")
	@Column(name="course")
	private List<String> course = new ArrayList<String>();
	
	
	@Column(name="addr")
	private String studAddr;
	
	@Column(name="cont")
	private Long studCont;
	
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudPwd() {
		return studPwd;
	}
	public void setStudPwd(String studPwd) {
		this.studPwd = studPwd;
	}
	public String getStudGen() {
		return studGen;
	}
	public void setStudGen(String studGen) {
		this.studGen = studGen;
	}
	public Integer getStudAge() {
		return studAge;
	}
	public void setStudAge(Integer studAge) {
		this.studAge = studAge;
	}
	public List<String> getCourse() {
		return course;
	}
	public void setCourse(List<String> course) {
		this.course = course;
	}
	
	public String getStudAddr() {
		return studAddr;
	}
	public void setStudAddr(String studAddr) {
		this.studAddr = studAddr;
	}
	public Long getStudCont() {
		return studCont;
	}
	public void setStudCont(Long studCont) {
		this.studCont = studCont;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studPwd=" + studPwd + ", studGen=" + studGen
				+ ", studAge=" + studAge + ", course=" + course + ", studAddr=" + studAddr + ", studCont=" + studCont
				+ "]";
	}
	
	
}
