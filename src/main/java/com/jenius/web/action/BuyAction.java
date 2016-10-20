package com.jenius.web.action;


public class BuyAction {
	
	private int code;
	private String message ;
	private String result;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String buyProduct()
	{
		
		this.result = "success";
		return "buyProduct";
	}          
}
