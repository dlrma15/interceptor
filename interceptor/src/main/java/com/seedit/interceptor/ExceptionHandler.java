package com.seedit.interceptor;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@ControllerAdvice
public class ExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@ResponseBody
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public Object exHandler(HttpServletRequest request, Exception ex, HttpServletResponse res) {
		logger.info("exception 진입");
		logger.info(request.getHeader("ajaxCheck"));
		if (!request.getHeader("ajaxCheck").isEmpty() && request.getHeader("ajaxCheck").equals("true")) {
			res.setStatus(500);
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", ex.getClass().getSimpleName());
			map.put("message", ex.getMessage());
			return new Gson().toJson(map);
		} else {
			logger.info("ajaxCheck 성공");
			ModelAndView mav = new ModelAndView();
			mav.addObject("name", ex.getClass().getSimpleName());
			mav.addObject("message", ex.getMessage());
			mav.setViewName("errorPage");
			return mav;
		}
	}
}