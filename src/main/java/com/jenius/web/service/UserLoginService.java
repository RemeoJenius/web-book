package com.jenius.web.service;

import java.util.Map;

import com.jenius.web.meta.User;

public interface UserLoginService {
	
	Map<String, Object> loginMessage(Map<String, Object> root,User user , String str);
}
