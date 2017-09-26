package com.seedit.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	LoginService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
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

	@RequestMapping(value = "/input", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public Object loginTest(HttpServletRequest request, @ModelAttribute @Valid Users user, BindingResult br) throws Exception {
		if (br.hasErrors()) {
			List<ObjectError> list = br.getAllErrors();
			for(ObjectError e :list) {
				throw new Exception(e.getDefaultMessage());
			}
			throw new Exception("Unknown Error");
		} 
		else {
			logger.info("Controller 진입");
			logger.info("SQL 리턴값 : " + service.loginTest(user));
			if (service.loginTest(user) != 0) {
				request.getSession().setAttribute("loginInfo", true);
				return "success_login";
			}
			return "fail";
		}

	}
}