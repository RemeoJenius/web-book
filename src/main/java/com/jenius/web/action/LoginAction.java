package com.jenius.web.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.jenius.web.dao.GetUserInfo;
import com.jenius.web.meta.User;
import com.jenius.web.service.UserLoginService;
import com.jenius.web.service.impl.UserLoinServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 登陆功能 
 */
@Controller
public class LoginAction implements ModelDriven<User> {

	private User user = new User();
	private HashMap<String, Object> root ;
	
	@Resource
	private UserLoginService userLoginService;
	
	public LoginAction(){
		root = new HashMap<String, Object>();
	}
	
	public HashMap<String, Object> getRoot() {
		return root;
	}

	public String login(){
		String str = null;
//		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-service.xml");
//		UserLoginService userLoginService = (UserLoginService) context.getBean(UserLoinServiceImpl.class);
		
		this.root = (HashMap<String, Object>) userLoginService.loginMessage(root, user, str);
		if (this.root.get("message") !=null){
			str = "error";
		}else{
			str = "success";
		}
		return str;
	}

	public User getModel() {
		return user;
	}
}
