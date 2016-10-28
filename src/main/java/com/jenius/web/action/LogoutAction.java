package com.jenius.web.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		Map<String , Object> session = ActionContext.getContext().getSession();
		session.remove("user");//如果用户点推出在session中移出user
		return SUCCESS;
	}
	
	
}
