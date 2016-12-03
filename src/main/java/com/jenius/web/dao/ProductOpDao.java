package com.jenius.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jenius.web.meta.Product;

public interface ProductOpDao {
	
	@Insert("insert into orders(userId,productId,buyTime,price) values(#{userId},#{productId},#{buyTime},#{price})")
	public void addProductToOrder(@Param("userId")int userId,@Param("productId")int productId,@Param("buyTime") long buyTime,@Param("price") double price);
	
	@Select("select p.id,title,description,imageAdress,o.price,buyTime from product p,orders o where p.id in (select productId from orders where userId=#{userId}) and p.id=o.productId and userId=#{userId}")
	public ArrayList<Product> getBuyProductList(int userId);
	
	@Delete("delete from orders where userId=#{userId} and productId=#{productId}")
	public void deleteProductById(@Param("userId")int userId , @Param("productId")int productId);
	
	@Insert("insert into product(title,description,imageAdress,price,introduction) values(#{product.title},#{product.description},#{product.imageAdress},#{product.price},#{product.introduction})")
	public void addProduct(@Param("product")Product product);
	
	@Delete("delete from product where id = #{productId}")
	public void deleteProduct(int productId);
	
	@Update("update product set title = #{product.title} ,description=#{product.description}, price=#{product.price},introduction=#{product.introduction} where id = #{product.id}")
	public void updateProduct(@Param("product")Product product);
} 
