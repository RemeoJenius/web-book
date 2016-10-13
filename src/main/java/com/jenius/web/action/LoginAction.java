package com.jenius.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jenius.web.meta.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<User> {

	private User user = new User();

	public String login() throws IOException {
		String str = null;
		ActionContext ac = ActionContext.getContext();
		if ("admin".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
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
