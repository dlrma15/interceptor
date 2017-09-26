package com.seedit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/success_login", method = RequestMethod.GET)
	public String successLogin() {
		return "success";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String loginTest(HttpServletRequest request, @ModelAttribute @Valid Users user) {
		if (service.loginTest(user)!=0) {
			request.getSession().setAttribute("loginInfo", true);
		}
		return "success";
	}
}