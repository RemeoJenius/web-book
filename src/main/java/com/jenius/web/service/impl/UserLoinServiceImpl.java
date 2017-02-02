package com.jenius.web.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jenius.web.dao.GetUserInfo;
import com.jenius.web.meta.User;
import com.jenius.web.service.UserLoginService;
import com.opensymphony.xwork2.ActionContext;


@Service
public class UserLoinServiceImpl implements UserLoginService{
	
	@Resource
	private GetUserInfo getUserInfo;

	public Map<String, Object> loginMessage(Map<String, Object> root ,User user , String str) {
		//ApplicationContext context  = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		//GetUserInfo getUserInfo = context.getBean("getUserInfo",GetUserInfo.class);//获取mybatis 接口对象
		ActionContext ac = ActionContext.getContext(); //获取ac容器
		User user1 = new User();
		user1 = getUserInfo.getUserInfo(user.getUsername(), user.getPassword());//用mybatis 接口对象的方法查找数据库，以户名和密码为过滤条件如果有把该用户的所有信息给user1
		if (user1 != null) {//说明数据库中有该用户
			Map<String, Object> session = ac.getSession();//获取ac容器封装的session对象
			session.put("user", user1);//将用户信息填到session中前端jsp用session容器获取
			root.put("user", user1);
			session.put("Login","OK");//拦截器 如果拦截器中session.get("Login") 是null说明没登录跳转到登陆页面
			str = "success";
		} else {
			str = "error";
			root.put("message", "用户名或密码错误!!！");
		}
		
		return root;
	}

}
