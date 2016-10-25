package com.jenius.web.meta;

public class Product {
	
	private int id;
	private String title;
	private String description;
	private String imageAdress;
	private double price;
	private long buyTime;
	private String buyTimeFormat;
	private String introduction;
	private int typeId;
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getBuyTimeFormat() {
		return buyTimeFormat;
	}
	public void setBuyTimeFormat(String buyTimeFormat) {
		this.buyTimeFormat = buyTimeFormat;
	}
	public long getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(long buyTime) {
		this.buyTime = buyTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageAdress() {
		return imageAdress;
	}
	public void setImageAdress(String imageAdress) {
		this.imageAdress = imageAdress;
	}
	
	
}
