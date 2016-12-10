package com.jenius.web.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetUserInfo;
import com.jenius.web.meta.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 登陆功能 
 */
public class LoginAction implements ModelDriven<User> {

	private User user = new User();
	private HashMap<String, Object> root ;
	
	public LoginAction(){
		root = new HashMap<>();
	}
	
	public HashMap<String, Object> getRoot() {
		return root;
	}


	public String login() throws IOException {
		String str = null;
		ApplicationContext context  = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		GetUserInfo getUserInfo = context.getBean("getUserInfo",GetUserInfo.class);//获取mybatis 接口对象
		ActionContext ac = ActionContext.getContext(); //获取ac容器
		User user1 = new User();
		user1 = getUserInfo.getUserInfo(user.getUsername(), user.getPassword());//用mybatis 接口对象的方法查找数据库，以户名和密码为过滤条件如果有把该用户的所有信息给user1
		if (user1 != null) {//说明数据库中有该用户
			Map<String, Object> session = ac.getSession();//获取ac容器封装的session对象
			session.put("user", user1);//将用户信息甜到session中前端jsp用session容器获取
			this.root.put("user", user1);
			session.put("Login","OK");//拦截器 如果拦截器中session.get("Login") 是null说明没登录跳转到登陆页面
			str = "success";
		} else {
//			Map<String, Object> request = (Map<String, Object>) ac.get("request");//获取request返回登陆错误信息
			str = "error";
//			request.put("message", "用户名或密码错误！");
			this.root.put("message", "用户名或密码错误！");
		}
		return str;
	}

	public User getModel() {
		return user;
	}
}
