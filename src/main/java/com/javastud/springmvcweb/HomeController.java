package com.javastud.springmvcweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javastud.springmvcweb.dao.UserDao;
import com.javastud.springmvcweb.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserDao userDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, User user, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "login";

	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profile(@ModelAttribute User user, Model model, HttpSession session) {
		if (userDao.validatUser(user)) {
			session.setAttribute("activeUser", user.getUsername());
			session.setMaxInactiveInterval(1 * 60);
			return "profile";

		} else {
			model.addAttribute("loginError", "Sorry !! Invalid Username & passsword.");
			return "login";
		}

	}
	
	
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String profile1(@ModelAttribute User user, Model model, HttpSession session) {
		
			
			return "NewFile";
		}

	

	// @RequestMapping(value = "/profile", method = RequestMethod.GET)
	// public String profileGet(@ModelAttribute User user, HttpSession session,
	// Model model) {
	//
	//
	//
	// String str=(String)session.getAttribute("activeUser");
	// if(str==null){
	// model.addAttribute("loginError","Login First");
	// return "login";
	// }
	// return "profile";
	// }
	//

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, User user) {
		session.invalidate();
		return "login";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileGet(HttpSession session) {
		if (StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "redirect:/";
		}
		return "profile";
	}
	
	
	 @RequestMapping(value = "/rest", method = RequestMethod.GET)
	    public String restCall() {
	        return "rest";
	    }
}
