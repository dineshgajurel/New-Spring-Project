package com.javastud.springmvcweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javastud.springmvcweb.dao.StudentDao;
import com.javastud.springmvcweb.model.Student;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(Model model) {
List<Student> studentList=studentDao.getAll();
		
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", studentList);
		return "studentForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String doPOST(Model model,@ModelAttribute Student student){
		studentDao.insertUpdate(student);
		List<Student> studentList=studentDao.getAll();
		
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", studentList);
		return "studentForm";
		
	}
	@RequestMapping( value ="{id}/edit" ,method=RequestMethod.GET)
	public String editStudent( Model model, @PathVariable("id") Long id){
    Student student=  studentDao.get(id);
		List<Student> studentList=studentDao.getAll();
		
		model.addAttribute("student", student);
		model.addAttribute("studentList", studentList);
		return "studentForm";
		
		
	}
	
	@RequestMapping( value="{id}/edit" ,method=RequestMethod.POST)
	public String editPOST(Model model,@ModelAttribute Student student){
		studentDao.insertUpdate(student);
		return "redirect:/student";
		
	}
	
	
	@RequestMapping( value ="{id}/delete" ,method=RequestMethod.GET)
	public String deleteStudent( Model model, @PathVariable("id") Long id){
    studentDao.delete(id);
    return "redirect:/student";
		
	}
	
	
}
