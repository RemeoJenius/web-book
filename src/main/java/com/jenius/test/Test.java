package com.jenius.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;

public class Test {

	public static void main(String[] args) {
		int a  = 1;
		int m ,n;
		m = a++ ;
		System.out.println(a);
		n= ++a;
		System.out.println(a);
		System.out.println("m= "+m);
		System.out.println("n = "+n);
		System.out.println(m + n);
	
	}
}
