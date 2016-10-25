package com.jenius.web.action;

import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ModelDriven;

public class EditProduct implements ModelDriven<Product>{

	private Product product = new Product();
	
	public String edit()
	{
		System.out.println("edit");
		return "edit";
	}
	
	public Product getModel() {
		return product;
	}
	
	
}
