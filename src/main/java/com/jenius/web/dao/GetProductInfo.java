package com.jenius.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.jenius.web.meta.Product;

public interface GetProductInfo {
	
	@Select("select * from product")
	public ArrayList<Product> getProductsInfo();
	@Select("select * from product where id = #{id}")
	public Product getProductsInfoById(int id);
	
	@Select("select * from product where typeid=1")
	public ArrayList<Product> getProductsInfoBy1();
	
	@Select("select * from product where typeid=2")
	public ArrayList<Product> getProductsInfoBy2();
	
	@Select("select * from product where typeid=3")
	public ArrayList<Product> getProductsInfoBy3();
	
	
}
