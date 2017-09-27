package com.seedit.interceptor;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@ControllerAdvice
public class ExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@ResponseBody
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public String exHandler(HttpServletRequest request, Exception ex, HttpServletResponse res){
		res.setStatus(500);
		logger.info("ExceptionHandler 진입");
		logger.info(ex.getClass().getSimpleName());
		logger.info(ex.getMessage());
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", ex.getClass().getSimpleName());
		map.put("message", ex.getMessage());
		logger.info(new Gson().toJson(map));
		return new Gson().toJson(map);
	}
}	