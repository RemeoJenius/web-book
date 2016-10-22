package com.jenius.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jenius.web.meta.Product;

public interface ProductOpDao {
	
	@Insert("insert into orders(userId,productId,buyTime,price) values(#{userId},#{productId},#{buyTime},#{price})")
	public void addProductToOrder(@Param("userId")int userId,@Param("productId")int productId,@Param("buyTime") long buyTime,@Param("price") double price);
	
	@Select("select title,description,imageAdress,o.price,buyTime from product p,orders o where p.id in (select productId from orders where userId=#{userId}) and p.id=o.productId and userId=#{userId}")
	public ArrayList<Product> getBuyProductList(int userId);
}
