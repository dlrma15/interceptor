package com.seedit.interceptor;

import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

@Alias("users")
public class Users {
	@Size(min=4, message="아이디는 4자 이상만 입력가능합니다")
	private String userId;
	@Size(min=4, message="비밀번호는 4자 이상만 입력가능합니다")
	private String pwd;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Users() {
	}

	public Users(String userId, String pwd) {
		this.userId = userId;
		this.pwd = pwd;
	}
}
