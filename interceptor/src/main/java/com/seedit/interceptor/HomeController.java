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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

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
	
	@RequestMapping(value = "/login2")
	public String login2() {
		return "login2";
	}

	@ResponseBody
	@RequestMapping(value = "/input", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public Object loginTest(HttpServletRequest request, @ModelAttribute @Valid Users user, BindingResult br) throws Exception {
		if (br.hasErrors()) {
				List<ObjectError> list = br.getAllErrors();
				for(ObjectError e :list) {
				throw new CustomException(e.getDefaultMessage());
			}
		} 
		else {
			logger.info("쿼리 실행결과 :"+service.loginTest(user));
			if (service.loginTest(user)> 0) {
				request.getSession().setAttribute("loginInfo", true);
				return new Gson().toJson("success");
			}
			request.getSession().removeAttribute("loginInfo");
			return new Gson().toJson("ID 혹은 비밀번호가 틀렸습니다");
		}
			throw new CustomException("알 수 없는 에러입니다");
	}
	
	@RequestMapping(value = "/input2", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public Object loginTest2(HttpServletRequest request, @ModelAttribute @Valid Users user, BindingResult br) throws Exception {
		throw new CustomException("알 수 없는 에러입니다");
	}
}