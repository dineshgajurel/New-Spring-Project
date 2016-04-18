package com.javastud.springmvcweb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	
public String showEmployee(Model model){

model.addAttribute("name","Mote");
		return "employee";
	
}
	
	@RequestMapping(value="/profil",method=RequestMethod.POST)
	
	public String showProfile1(Model user ,HttpServletRequest req){
		
String username=req.getParameter("username");

	user.addAttribute("username",username);
			return "profile";
		
	}
@RequestMapping(value="/profiless",method=RequestMethod.GET)
	
	public String showProfileGet(Model model){

	model.addAttribute("name","Mote");
			return "profile";
		
	}
}
