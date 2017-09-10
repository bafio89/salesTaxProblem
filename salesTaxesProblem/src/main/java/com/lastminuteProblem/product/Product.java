package com.lastminuteProblem.product;

public class Product {

	int quantity;
	
	String name;
	
	float price;
	
	boolean	baseTaxFree;
	
	boolean imported;
	
	
	public Product(int quantity, String name, float price, boolean baseTaxFree, boolean imported) {
		
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.baseTaxFree = baseTaxFree;
		this.imported = imported;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isBaseTaxFree() {
		return baseTaxFree;
	}
	public void setBaseTaxFree(boolean baseTaxFree) {
		this.baseTaxFree = baseTaxFree;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	
	
}
