package com.jenius.web.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;
import com.jenius.web.meta.Product;
import com.jenius.web.meta.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {

	private HashMap<String, Object> req ;
	
	
	public MainAction(){
		req = new HashMap<String, Object>();
	}
	
	public HashMap<String, Object> getRoot() {
		return req;
	}

	public String main() {
//		Map<String, Object> application = ActionContext.getContext().getApplication();//获取application容器
		ArrayList<Product> productList = new ArrayList<Product>();//实例化product对象的列表
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);//获取mbatis对象
		productList = getProductInfo.getProductsInfo();//调用接口方法 获取数据库中所有商品信息
//		application.put("productList", productList);//struts2 ac容器进行后台渲染被前端渲染代替
		this.req.put("product_list", productList);
		return SUCCESS;
	}

}
