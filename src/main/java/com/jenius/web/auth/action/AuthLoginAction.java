package com.jenius.web.auth.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetUserInfo;
import com.jenius.web.meta.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class AuthLoginAction implements ModelDriven<User>{

	private User user = new User();


	public String login() throws IOException {
		String str = null;
		ApplicationContext context  = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		GetUserInfo getUserInfo = context.getBean("getUserInfo",GetUserInfo.class);//获取mybatis 接口对象
		ActionContext ac = ActionContext.getContext(); //获取ac容器
		User user1 = new User();
		System.out.println("user: "+user.getUsername());
		user1 = getUserInfo.getUserInfo(user.getUsername(), user.getPassword());//用mybatis 接口对象的方法查找数据库，以户名和密码为过滤条件如果有把该用户的所有信息给user1
		if (user1 != null) {//说明数据库中有该用户
			System.out.println("555");
			Map<String, Object> session = ac.getSession();//获取ac容器封装的session对象
			session.put("user", user1);//将用户信息甜到session中前端jsp用session容器获取
			session.put("Login","OK");//拦截器 如果拦截器中session.get("Login") 是null说明没登录跳转到登陆页面
			str = "success";
		} else {
			str = "error";
		}
		return str;
	}


	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	
}
