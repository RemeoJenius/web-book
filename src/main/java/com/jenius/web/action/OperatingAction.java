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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 对商品的操作主要是卖家的操作
 */

public class OperatingAction extends ActionSupport implements ModelDriven<Product>{

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

	public String delete() {   //对商品进行删除操作
		HttpServletRequest request = ServletActionContext.getRequest();//获取request对象  
		int id = Integer.parseInt(request.getParameter("id"));//转换id为int
		int userId = Integer.valueOf(((User)session.get("user")).getId());//获取user的id并转换为int
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		ProductOpDao productOpDao = context.getBean("productOpDao" ,ProductOpDao.class);//获取mybatis 接口对象
		productOpDao.deleteProductById(userId, id);//调用 接口方法 商品id和用户id 为过滤条件对商品进行删除
		this.result = "success";//json 返回成功信息
		this.message = "商品删除成功";
		
		return "delete";
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	//商品购买方法
	public String buyProduct() {
		int id;
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");//获取ioc容器
		ProductOpDao op = context.getBean("productOpDao",ProductOpDao.class); //获取mybatis 接口对象（依赖注入） 
		HttpServletRequest request = ServletActionContext.getRequest(); //获取request对象
		int Userid= ((User)session.get("user")).getId();//强制类型转换userid
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);//获取mybatis接口对象
		if(request.getParameter("id") != null)// 遇到情况 购买商品 要获取商品id 在主页面使用http get方法所以用的request获取id 而详情页要用session获取id所以要判断   
		{
			id = Integer.parseInt(request.getParameter("id"));
		}else {
			id = (((Product)(session.get("product"))).getId());
		}
		op.addProductToOrder(Userid, id, new Date().getTime(), getProductInfo.getProductsInfoById(id).getPrice());//点用接口方法将该商品添加到购物车
		this.result = "success";//返回json
		this.message = "商品buy成功";
		return "buyProduct";
	}
	public String deleteProduct()//卖家删除商品
	{
		HttpServletRequest request = ServletActionContext.getRequest();//获取request  
		int id = Integer.parseInt(request.getParameter("id"));//获取商品id 购物车页中删除
		int userId = Integer.valueOf(((User)session.get("user")).getId());//获取userid
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);//获取 mybatis 接口对象
		if(DeleteImage.deleteFile(getProductInfo.getProductsInfoById(id).getImageAdress()))//删除商品图片  方法的参数是图片的地址
		{
			this.result = "success";
			this.message = "商品删除成功";
		}
		ProductOpDao productOpDao = context.getBean("productOpDao" ,ProductOpDao.class);//获取mybatis 接口对象
		productOpDao.deleteProduct(id);//调用方法删除商品
		return "deleteProduct";
	}
	
	public String editData()//卖家点击修改 回到一个表单页，表单中有值 ，值是从数据库中取出来填充到容器中
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		HttpServletRequest request = ServletActionContext.getRequest();//获取request对象为了获取jsp用http get方法传来的id
		Map<String ,Object> sessioon = ActionContext.getContext().getSession();//获取session容器
		GetProductInfo getProductInfo = context.getBean("getProductInfo",GetProductInfo.class);//取到mybatis 接口
		int	id = Integer.parseInt(request.getParameter("id"));//强制类型转换id为int
		session.put("product", getProductInfo.getProductsInfoById(id));//用mybatis 接口方法将数据库中查到的商品加到容器中
		return "editData";
	}
	public String editProduct()//修改商品信息   从表单中获取呀商品信息（不对照进行修改片）
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");//获取IOC容器
		int id = (((Product)(session.get("product"))).getId());//获取商品id
		ProductOpDao productOpDao = context.getBean("productOpDao",ProductOpDao.class);//获取mybatis接口对象
		productOpDao.updateProduct(product);//调用接口对象方法 更新数据表
		this.result = "success";
		this.message="商品修改成功";//返回json
		return "editProduct";
	}
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return INPUT;
	}
	
}
