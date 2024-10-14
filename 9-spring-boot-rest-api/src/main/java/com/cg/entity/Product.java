package com.cg.entity;

public class Product {
private int prodId;
private String prodName;
private float price;

public Product() {
	// TODO Auto-generated constructor stub
}

public Product(int prodId, String prodName, float price) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.price = price;
}

public int getProdId() {
	return prodId;
}

public void setProdId(int prodId) {
	this.prodId = prodId;
}

public String getProdName() {
	return prodName;
}

public void setProdName(String prodName) {
	this.prodName = prodName;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

}
