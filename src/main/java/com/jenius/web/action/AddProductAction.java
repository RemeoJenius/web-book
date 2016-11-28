package com.jenius.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.ProductOpDao;
import com.jenius.web.meta.Product;
import com.jenius.web.util.FileUploadRename;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 卖家添加商品操作 实现了表单数据的获取和图片的获取
 */
public class AddProductAction implements ModelDriven<Product>{

	
	private File upload;  //图片文件
	private String uploadContextType; //文件类型
	private String uploadFileName;  //文件名称
	private String result;   //返回值  json
	private Product product = new Product();  //接受表单数据
	 /*
	  *  struts2文件上传必须实现  文件、文件类型、文件名称的getter setter方法
	  */
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContextType() {
		return uploadContextType;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String addProduct() throws IOException
	{
		String path = "/Volumes/资源/workspace/web-book/src/main/webapp/images";//相对地址有问题还未解决，绝对地址可以但是代码的可移植性变差
		File file  = new File(path);
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");//spring 框架获取mybatis
		ProductOpDao productOpDao = context.getBean("productOpDao",ProductOpDao.class);//获取mybatis 接口的对象
		if(!file.exists() )  //如果目录不存在 新建目录
		{
			file.mkdirs();
		}
		uploadFileName = FileUploadRename.fileRename(uploadFileName);
		product.setImageAdress("images/"+uploadFileName); //设置 商品的图片地址
		FileUtils.copyFile(upload, new File(file,uploadFileName));//复制商品图片到 图片目录下
		productOpDao.addProduct(product); //调用 mybatis 接口的方法 添加商品 
		try {
			Thread.sleep(2000);//由于eclipse设置文件外部修改自动更新 但是会有延时会出现图片文件没到目录就给主页返回图片地址会导致主页上图片不存在
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = "上传成功";
		return "add"; //返回字符串给struts.xml
	}
	
	public Product getModel() { //由于实现 ModelDriven接口所以要实现该接口的方法 
		return product;
	}

}
