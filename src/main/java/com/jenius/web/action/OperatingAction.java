package com.jenius.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.ProductOpDao;
import com.jenius.web.meta.Product;
import com.jenius.web.meta.User;
import com.opensymphony.xwork2.ActionContext;

public class OperatingAction {

	private String result;
	private String message;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String delete() {

		System.out.println("delete");
		this.result = "success";
		this.message = "商品删除成功";
		return "delete";
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String buyProduct() {
		ArrayList<Product> ps = new ArrayList<Product>();
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		ProductOpDao op = context.getBean("op",ProductOpDao.class);
		op.addProductToOrder(1, 1, new Date().getTime(), 55);
		this.result = "success";
		this.message = "商品购买成功";
		System.out.println("buy");
		return "buyProduct";
	}
}
