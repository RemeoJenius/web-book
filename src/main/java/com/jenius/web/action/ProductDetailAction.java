package com.jenius.web.action;


import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.ServletActionContext;

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
		String resource = "confAnnotation.xml";
		// 2.加载应用配置文件
		InputStream is = MainAction.class.getClassLoader().getResourceAsStream(resource);
		// 3.创建SqlSessionFctory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		Configuration conf = sessionFactory.getConfiguration();
		conf.addMapper(GetProductInfo.class);
		SqlSession session1 = sessionFactory.openSession();
		GetProductInfo getProductInfo = session1.getMapper(GetProductInfo.class);
		Product product = getProductInfo.getProductsInfoById(id);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("product", product);
		return "detail";
	}
	
}
