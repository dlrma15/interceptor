package com.seedit.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	LoginDao dao;
	
	public int loginTest(Users user) {
		return dao.loginTest(user);
	}
}
