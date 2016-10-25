package com.jenius.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jenius.web.dao.ProductOpDao;
import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ModelDriven;

public class AddProductAction implements ModelDriven<Product>{

	
	private File upload;
	private String uploadContextType;
	private String uploadFileName;
	private String result;
	private Product product = new Product();

	
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
		String path = "/Volumes/资源/workspace/web-book/src/main/webapp/images";
		File file  = new File(path);
		ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		ProductOpDao productOpDao = context.getBean("productOpDao",ProductOpDao.class);
		if(!file.exists() )
		{
			file.mkdirs();
		}
		product.setImageAdress("images/"+uploadFileName);
		System.out.println(product.getTitle());
		System.out.println(product.getTypeId());
		System.out.println(product.getImageAdress());
		System.out.println(product.getIntroduction());
		System.out.println(product.getDescription());
		System.out.println(product.getPrice());
		FileUtils.copyFile(upload, new File(file,uploadFileName));
		productOpDao.addProduct(product);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = "上传成功";
		return "add";
	}
	
	public Product getModel() {
		return product;
	}

}
