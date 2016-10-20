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

import com.jenius.web.dao.GetUserInfo;
import com.jenius.web.meta.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<User> {

	private User user = new User();

	public String login() throws IOException {
		String str = null;
		ActionContext ac = ActionContext.getContext();
		String resource = "confAnnotation.xml";
		// 2.加载应用配置文件
		InputStream is = MainAction.class.getClassLoader().getResourceAsStream(resource);
		// 3.创建SqlSessionFctory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		Configuration conf = sessionFactory.getConfiguration();
		conf.addMapper(GetUserInfo.class);
		SqlSession session1 = sessionFactory.openSession();
		GetUserInfo getUserInfo = session1.getMapper(GetUserInfo.class);
		User user1 = new User();
		user1 = getUserInfo.getUserInfo(user.getUsername(), user.getPassword());
		if (user1 != null) {
			Map<String, Object> session = ac.getSession();
			session.put("user", user);
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
