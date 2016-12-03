package com.jenius.web.action;

import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 卖家修改商品信息 已在OperatingAction.java 中用editProject 方法中实现
 */
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
