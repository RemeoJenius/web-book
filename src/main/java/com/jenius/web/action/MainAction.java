package com.jenius.web.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.jenius.web.dao.GetProductInfo;
import com.jenius.web.meta.Product;
import com.jenius.web.meta.User;
import com.jenius.web.service.impl.PageServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class MainAction extends ActionSupport {

	private HashMap<String, Object> req;
	private int pageNumber;
	@Resource
	private GetProductInfo getProductInfo;
	
	@Resource
	private PageServiceImpl pageServiceImpl;
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public MainAction() {
		req = new HashMap<String, Object>();
	}

	public HashMap<String, Object> getreq() {
		return req;
	}

	public String main() {
		ArrayList<Product> productList = new ArrayList<Product>();// 实例化product对象的列表
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		productList = getProductInfo.getProductsInfo();// 调用接口方法 获取数据库中所有商品信息
		ArrayList<Product> pageProductList = new ArrayList<Product>();// 实例化product对象的列表
		for (Product product : productList) {
			if (product.getTypeId() == 2) {
				product.setShow(true);
			}
		}
		this.req.put("product_list",pageServiceImpl.paging(pageNumber, pageProductList, productList));
		this.req.put("pages", pageServiceImpl.pageCount(productList));
		if (session.get("user") != null) {
			this.req.put("user", session.get("user"));
		}
		return SUCCESS;
	}

}
