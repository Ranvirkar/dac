package com.swp.entites;

import java.time.LocalDate;

public class Pen {

	private static int count=0;
	private int id;
	private String brand;
	private String color;
	private String inkColor;
	private String material;
	private int stock;
	private LocalDate updateDate;
	private LocalDate listDate;
	private double price;
	private double discount;

	public Pen() {
		super();
	}

	public Pen(String brand, String color, String inkColor, String material, int stock, LocalDate updateDate,
			LocalDate listDate, double price) {
		super();
		count = ++count;
		this.id =count;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = count;
		this.updateDate = updateDate;
		this.listDate = listDate;
		this.price = price;
		this.discount = 0.0;
	}

	public Pen(String brand, String color, String ink, String material, double price) {
		count = ++count;
		this.id =count;
		this.brand = brand;
		this.color = color;
		this.inkColor = ink;
		this.material = material;
		this.price = price;
		this.listDate=LocalDate.now();
		this.updateDate=LocalDate.now();
		this.discount=0.0;
		this.stock=count;
	}

	public int getId() {
		return id;
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDate getListDate() {
		return listDate;
	}

	public void setListDate(LocalDate listDate) {
		this.listDate = listDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
	
	@Override
	public String toString() {
		return "Pen Id=" + id + "\nBrand=" + brand + "\nColor=" + color + "\nInk Color=" + inkColor + "\nMaterial="
				+ material + "\nStock=" + stock + "\nUpdateDate=" + updateDate + "\nListDate=" + listDate + "\nPrice="
				+ price + "\nDiscount=" + discount ;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Pen) {
			Pen new_name = (Pen) o;
			return this.id==new_name.id;
		}
		return false;
	}

}
