package com.jenius.web.action;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;
import com.jenius.web.dao.ProductOpDao;
import com.jenius.web.meta.Product;
import com.jenius.web.meta.User;
import com.opensymphony.xwork2.ActionContext;

public class ProductList {
	
	
	public String list()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		Map<String , Object> session = ActionContext.getContext().getSession();
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductOpDao op = context.getBean("productOpDao",ProductOpDao.class);
		productList = op.getBuyProductList(((User)(session.get("user"))).getId());
		session.put("productList", productList);
		session.put("message", true);    
		return "list";
	}
}
