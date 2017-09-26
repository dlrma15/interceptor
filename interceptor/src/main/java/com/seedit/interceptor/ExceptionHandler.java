package com.seedit.interceptor;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	@ResponseBody
	public String exHandler(HttpServletRequest request, Exception ex){
		return new Gson().toJson(ex.getMessage());
	}
}
