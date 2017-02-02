package com.jenius.web.service;

import java.util.ArrayList;

import com.jenius.web.meta.Product;

public interface PageService {
	ArrayList paging(int pageNumber, ArrayList<Product> pageProductList, ArrayList<Product> productList);
	ArrayList<Integer> pageCount(ArrayList<Product> productList);
}
