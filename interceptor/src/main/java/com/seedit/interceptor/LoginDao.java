package com.seedit.interceptor;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	@Autowired
	SqlSessionTemplate tpl;

	public int loginTest(Users user) {
		return tpl.selectOne("com.seedit.interceptor.login",user);
	}
}
