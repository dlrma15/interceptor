package com.seedit.interceptor;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	@ResponseBody
	public String exHandler(HttpServletRequest request, Exception ex){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", ex.getClass().getSimpleName());
		map.put("message", ex.getMessage());
		return new Gson().toJson(map);
	}
}
