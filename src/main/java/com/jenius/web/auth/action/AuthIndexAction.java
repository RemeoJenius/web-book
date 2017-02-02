package com.jenius.web.auth.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;
import com.jenius.web.meta.Product;

public class AuthIndexAction {
	
	private Map<String, Object> req = new HashMap<String, Object>();
	
	
	
	public Map<String, Object> getReq() {
		return req;
	}



	public void setReq(Map<String, Object> req) {
		this.req = req;
	}



	public String auth(){
		
		ArrayList<Product> productList = new ArrayList<Product>();//实例化product对象的列表
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);//获取mbatis对象
		productList = getProductInfo.getProductsInfo();//调用接口方法 获取数据库中所有商品信息
		req.put("product_list",productList );
		
		return "success";
	}
}
