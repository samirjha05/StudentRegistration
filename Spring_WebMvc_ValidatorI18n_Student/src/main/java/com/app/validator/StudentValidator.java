package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Student;

public class StudentValidator implements Validator{

	public boolean supports(Class<?> cls) {
		
		return Student.class.equals(cls);
	}

	public void validate(Object target, Errors errors) {
		Student s = (Student)target;
		
		if(!Pattern.compile("[A-Za-z]{3,9}").matcher(s.getStudName()).matches()) {
			errors.rejectValue("studName", "studNameError");
		}
		if(!Pattern.compile("[A-Za-z0-9]{3,8}").matcher(s.getStudPwd()).matches()) {
			errors.rejectValue("studPwd", "studPwdError");
		}
		
		if(s.getStudAge()<=4|| s.getStudAge()==null || "".equals(s.getStudAge())) {
			errors.rejectValue("studAge", "studAgeError");
		}
		if(s.getStudGen()==null || "".equals(s.getStudGen())) {
			errors.rejectValue("studGen", "studGenError");
		}
		if(s.getCourse()==null || "".equals(s.getCourse())) {
			errors.rejectValue("course", "courseError");
		}
		
		if(s.getStudAddr()==null || "".equals(s.getStudAddr())) {
			errors.rejectValue("studAddr", "studAddrError");
		}
		if(s.getStudCont()<10 || s.getStudCont()>10 || s.getStudCont()==null) {
			errors.rejectValue("studCont", "studContError");
		}
	}

}
