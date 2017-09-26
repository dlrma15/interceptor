package com.seedit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			if (request.getSession().getAttribute("loginInfo") == null) {
				response.sendRedirect("/interceptor/login");
				return false;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}