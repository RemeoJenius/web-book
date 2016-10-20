package com.jenius.web.meta;

public class Product {
	
	private int id;
	private String title;
	private String description;
	private String imageAdress;
	private double price;
	
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
