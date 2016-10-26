package com.jenius.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;

public class Test {

	public static void main(String[] args) {
		int a  = 1;
		a= a+++a;
		System.out.println("1. "+a);// 3
		a = 1;
		a = (a++)+a;  
		System.out.println("2. "+a);  //3
		a = 1;
		a = a+(++a);  
		System.out.println("3. "+a);  //3
	}
}
