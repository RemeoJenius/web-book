package com.jenius.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);
		System.out.println(getProductInfo.getProductsInfoById(1).getDescription());
	}
}
