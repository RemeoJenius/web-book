package com.jenius.web.action;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;
import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailAction extends ActionSupport {
	
	private Product product;
	private Map<String, Object> req = new HashMap<String, Object>();
	
	
	public Map<String, Object> getReq() {
		return req;
	}


	public void setReq(Map<String, Object> req) {
		this.req = req;
	}


	public String productDetail()
	{
		HttpServletRequest request = ServletActionContext.getRequest();  
		int id = Integer.parseInt(request.getParameter("id"));
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);
		product = getProductInfo.getProductsInfoById(id);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("product", product);
		this.req.put("product", product);
		if(session.get("user")!=null){
			this.req.put("user", session.get("user"));
		}
		return "detail";
	}
	
}
