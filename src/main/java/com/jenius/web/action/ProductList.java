package com.jenius.web.action;

import java.text.SimpleDateFormat;
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
	
	private String message;
	private String result;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String list()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		Map<String , Object> session = ActionContext.getContext().getSession();
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductOpDao op = context.getBean("productOpDao",ProductOpDao.class);
		System.out.println(((User)(session.get("user"))).getId());
		productList = op.getBuyProductList(((User)(session.get("user"))).getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
		for (Product p : productList){
			System.out.println("id"+ p.getId());
			p.setBuyTimeFormat(sdf.format(p.getBuyTime()));
		}
		session.put("productList", productList);
		setMessage("删除成功");
		this.result = "success";
		return "list";
	}
}
