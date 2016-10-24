package com.jenius.web.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.ProductOpDao;
import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ModelDriven;

public class AddProductAction implements ModelDriven<Product>{

	
	private Product product = new Product();
	public String addProduct()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		ProductOpDao productOpDao = context.getBean("productOpDao",ProductOpDao.class);
		System.out.println("title="+product.getTitle());
//		productOpDao.addProduct(product);
		return "add";
	}
	
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

}
