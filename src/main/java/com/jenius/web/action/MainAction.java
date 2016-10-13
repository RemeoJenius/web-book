package com.jenius.web.action;

import java.util.ArrayList;
import java.util.Map;

import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		Map<String , Object> application = ActionContext.getContext().getApplication();
		ArrayList<Product> productList = new ArrayList<Product>();
		Product p = new Product();
		p.setDescription("One or two sentence description that may go to several lines");
		p.setImageAdress("images/java.jpeg");
		p.setTitle("Java从入门到精通");
		productList.add(p);
		
		application.put("productList", productList);
		return SUCCESS;
	}
	
}
