package com.jenius.web.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jenius.web.dao.GetProductInfo;
import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		Map<String, Object> application = ActionContext.getContext().getApplication();
		ArrayList<Product> productList = new ArrayList<Product>();
		// 1.声明配置文件的目录
		String resource = "confAnnotation.xml";
		// 2.加载应用配置文件
		InputStream is = MainAction.class.getClassLoader().getResourceAsStream(resource);
		// 3.创建SqlSessionFctory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		Configuration conf = sessionFactory.getConfiguration();
		conf.addMapper(GetProductInfo.class);
		SqlSession session = sessionFactory.openSession();
		GetProductInfo getProductInfo = session.getMapper(GetProductInfo.class);
		productList = getProductInfo.getProductsInfo();
		application.put("productList", productList);
		return SUCCESS;
	}

}
