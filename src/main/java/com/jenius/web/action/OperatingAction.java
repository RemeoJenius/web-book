package com.jenius.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;
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
		Map<String,Object> sessioon = ActionContext.getContext().getSession();
		ArrayList<Product> ps = new ArrayList<Product>();
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		ProductOpDao op = context.getBean("productOpDao",ProductOpDao.class);
		HttpServletRequest request = ServletActionContext.getRequest();  
		int id = Integer.parseInt(request.getParameter("id"));
		int Userid= ((User)session.get("user")).getId();
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class); 
		op.addProductToOrder(Userid, id, new Date().getTime(), getProductInfo.getProductsInfoById(id).getPrice());
		this.result = "success";
		this.message = "商品购买成功";
		return "buyProduct";
	}
}
