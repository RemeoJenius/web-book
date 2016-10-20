package com.jenius.web.action;


import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;
import com.jenius.web.dao.GetUserInfo;
import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailAction extends ActionSupport {
	
	public String productDetail()
	{
		HttpServletRequest request = ServletActionContext.getRequest();  
		int id = Integer.parseInt(request.getParameter("id"));
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);
		Product product = getProductInfo.getProductsInfoById(id);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("product", product);
		return "detail";
	}
	
}
