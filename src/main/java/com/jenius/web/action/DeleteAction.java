package com.jenius.web.action;

import java.util.ArrayList;
import java.util.Map;

import com.jenius.web.meta.Product;
import com.opensymphony.xwork2.ActionContext;

public class DeleteAction {
	private String result;
	
	public String getResylt() {
		return result;
	}

	public void setResylt(String resylt) {
		this.result = resylt;
	}

	public String delete() {
		
		this.result = "success";
		Map<String , Object> session = ActionContext.getContext().getSession();
		System.out.println(((ArrayList<Product>)session.get("productList")).get(0).getTitle());
		((ArrayList<Product>)session.get("productList")).remove(((ArrayList<Product>)session.get("productList")).get(0));
//		System.out.println(session.get("productList").toString());
		return "delete";
	}
}
