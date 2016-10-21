package com.jenius.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jenius.web.meta.Product;

public interface ProductOpDao {
	
	@Insert("insert into orders(userId,productId,buyTime,price) values(#{userId},#{productId},#{buyTime},#{price})")
	public void addProductToOrder(int userId,int productId,long buyTime,double price);
	
	@Select("select title,description,imageAdress,price,buyTime from product,orders o where o.userId = #{} ")
	public ArrayList<Product> getBuyProductList(int userId);
}
