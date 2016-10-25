package com.jenius.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.GetProductInfo;
import com.jenius.web.dao.ProductOpDao;
import com.jenius.web.meta.Product;
import com.jenius.web.meta.User;
import com.jenius.web.util.DeleteImage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class OperatingAction implements ModelDriven<Product>{

	private String result;
	private String message;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private Product product = new Product();
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();  
		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.valueOf(((User)session.get("user")).getId());
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		ProductOpDao productOpDao = context.getBean("productOpDao" ,ProductOpDao.class);
		productOpDao.deleteProductById(userId, id);
		this.result = "success";
		this.message = "商品删除成功";
		
		return "delete";
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String addProduct()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		ProductOpDao productOpDao = context.getBean("productOpDao",ProductOpDao.class);
		System.out.println("title="+product.getTitle());
		productOpDao.addProduct(product);
		return "addProduct";
	}
	public String buyProduct() {
		int id;
		ArrayList<Product> ps = new ArrayList<Product>();
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		ProductOpDao op = context.getBean("productOpDao",ProductOpDao.class);
		HttpServletRequest request = ServletActionContext.getRequest();  
		int Userid= ((User)session.get("user")).getId();
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);
		if(request.getParameter("id") != null)
		{
			id = Integer.parseInt(request.getParameter("id"));
		}else {
			id = (((Product)(session.get("product"))).getId());
		}
		op.addProductToOrder(Userid, id, new Date().getTime(), getProductInfo.getProductsInfoById(id).getPrice());
		this.result = "success";
		this.message = "商品购买成功";
		return "buyProduct";
	}
	public String deleteProduct()
	{
		System.out.println("deleteProduct");
		HttpServletRequest request = ServletActionContext.getRequest();  
		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.valueOf(((User)session.get("user")).getId());
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);
		if(DeleteImage.deleteFile(getProductInfo.getProductsInfoById(id).getImageAdress()))
		{
			this.result = "success";
			this.message = "商品删除成功";
		}
		ProductOpDao productOpDao = context.getBean("productOpDao" ,ProductOpDao.class);
		productOpDao.deleteProduct(id);
		return "deleteProduct";
	}
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
}
