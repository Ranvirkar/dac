package com.petstore.entities;

public class Pet {
	private static int count = 100;
	private int petid;
	private String name;
	private Category category;
	private double price;
	private int stock;

	public Pet() {
		super();
	}

	public Pet(String name, Category category, double price, int stock) {
		super();

		this.petid = ++count;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	public int getPetid() {
		return petid;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void setPetid(int petid) {
		this.petid = petid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Pet [petid=" + petid + ", name=" + name + ", category=" + category + ", price=" + price + ", stock="
				+ stock + "]";
	}
	

}
