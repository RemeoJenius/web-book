package com.jenius.web.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{
	
	private Map<String, Object> root = new HashMap<String, Object>();

	public Map<String, Object> getRoot() {
		return root;
	}

	public void setRoot(Map<String, Object> root) {
		this.root = root;
	}

	@Override
	public String execute() throws Exception {
		Map<String , Object> session = ActionContext.getContext().getSession();
		session.remove("user");//如果用户点推出在session中移出user
		root.put("ok", "ok");
		return "logout";
	}
	
}
