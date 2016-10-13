package com.jenius.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.jenius.web.meta.Product;

public interface GetProductInfo {
	
	@Select("select * from product")
	public ArrayList<Product> getProductsInfo();
	
}
