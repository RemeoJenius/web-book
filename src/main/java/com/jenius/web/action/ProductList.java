package com.jenius.web.action;

import java.util.ArrayList;
import java.util.Map;

import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ActionContext;

public class ProductList {
	
	
	public String list()
	{
		Map<String , Object> session = ActionContext.getContext().getSession();
		
		ArrayList<Product> productList = new ArrayList<Product>();
		Product p = new Product();
		System.out.println("test");
		p.setDescription("One or two sentence description that may go to several lines");
		p.setImageAdress("images/java.jpeg");
		p.setTitle("Java从入门到精通");
		productList.add(p);
		session.put("productList", productList);
		session.put("message", true);    
		return "list";
	}
}
