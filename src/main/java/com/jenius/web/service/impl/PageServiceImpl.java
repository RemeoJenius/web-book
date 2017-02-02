package com.jenius.web.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jenius.web.meta.Product;
import com.jenius.web.service.PageService;


public class PageServiceImpl implements PageService{

	public ArrayList<Product> paging(int pageNumber, ArrayList<Product> pageProductList, ArrayList<Product> productList) {
		if(pageNumber != 0){
			for (int i = 0,j =pageNumber*3-3;i<3;i++){
				if (j< productList.size())
					pageProductList.add(productList.get(j++));
			}
			return pageProductList;
		}else{
			return productList;
		}
		
	}
	public ArrayList<Integer> pageCount(ArrayList<Product> productList){
		ArrayList<Integer> pages = new ArrayList<Integer>(); 
		for(int i =0;i<=productList.size()/3;i++){
			pages.add(i);
		}
			
		return pages;
	}
	
	
	
}
