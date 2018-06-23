package com.app.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Student;
import com.app.service.IStudentService;
import com.app.validator.StudentValidator;

@Controller
public class StudentController {

	@Autowired
	private MessageSource ms;
	@Autowired
	private IStudentService service;
	@Autowired
	private StudentValidator validator;
	
	
	
	@GetMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("student", new Student());
		return "StudentRegister";
	}
	
	@PostMapping("/insert")
	public String saveData(@ModelAttribute Student student,Errors errors,ModelMap map,Locale locale) {
		validator.validate(student, errors);
		if(errors.hasErrors()) {
			map.addAttribute("student", new Student());
		}
		else {
			Integer studId = service.save(student);
			String msg = ms.getMessage("saveSuccess", new Object[] {studId}, locale);
			map.addAttribute("message", msg);
			map.addAttribute("student", new Student());
		}
		return "StudentRegister";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studId")Integer studId,ModelMap map,Locale locale) {
		 service.deleteById(studId);
		List<Student> stds = service.getAll();
		map.addAttribute("stds", stds);
		String msg = ms.getMessage("deleteSuccess", new Object[] {studId}, locale);
		map.addAttribute("message", msg);
		return "StudentData";
	}
	
	@GetMapping("/all")
	public String showAll(ModelMap map) {
		List<Student> stds = service.getAll();
		map.addAttribute("stds", stds);
		return "RegisterData";
	}
	
}
