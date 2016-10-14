package com.jenius.web.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jenius.web.meta.User;

public interface GetUserInfo {

	@Select("select * from users where username = #{username} and password = #{password}")
	public User getUserInfo(@Param("username")String username, @Param("password")String password);
	
}
