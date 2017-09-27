package com.seedit.interceptor;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	@Autowired
	SqlSessionTemplate tpl;

	public int loginTest(Users user) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", user.getUserId());
		map.put("pwd", user.getPwd());
		return tpl.selectOne("com.seedit.interceptor.loginCheck",map);
	}
}