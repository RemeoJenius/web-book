package com.jenius.web.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

public class LoginAction implements ModelDriven<User> {

	private User user = new User();

	public String login() throws IOException {
		String str = null;
		ApplicationContext context  = new ClassPathXmlApplicationContext("application-dao.xml");
		GetUserInfo getUserInfo = context.getBean("getUserInfo",GetUserInfo.class);
		ActionContext ac = ActionContext.getContext();
		User user1 = new User();
		user1 = getUserInfo.getUserInfo(user.getUsername(), user.getPassword());
		if (user1 != null) {
			Map<String, Object> session = ac.getSession();
			session.put("user", user1);
			str = "success";
		} else {
			Map<String, Object> request = (Map<String, Object>) ac.get("request");
			str = "error";
			request.put("message", "用户名或密码错误！");
		}
		return str;
	}

	public String message() throws IOException {
		
		return null;
	}

	public User getModel() {
		return user;
	}
}
