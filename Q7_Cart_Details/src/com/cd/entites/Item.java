package com.cd.entites;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {
private String itemcode;
private String  descrip;
private double price;
private LocalDate shipDtae;

public Item(String itemcode, String descrip, double price, LocalDate shipDtae) {
	super();
	this.itemcode = itemcode;
	this.descrip = descrip;
	this.price = price;
	this.shipDtae = shipDtae;
}

public String getItemcode() {
	return itemcode;
}

public String getDescrip() {
	return descrip;
}

public double getPrice() {
	return price;
}

public LocalDate getShipDtae() {
	return shipDtae;
}

public void setItemcode(String itemcode) {
	this.itemcode = itemcode;
}

public void setDescrip(String descrip) {
	this.descrip = descrip;
}

public void setPrice(double price) {
	this.price = price;
}

public void setShipDtae(LocalDate shipDtae) {
	this.shipDtae = shipDtae;
}

@Override
public String toString() {
	return "Item [itemcode=" + itemcode + ", descrip=" + descrip + ", price=" + price + ", shipDtae=" + shipDtae + "]";
}

@Override
public boolean equals(Object o) {
	if (o instanceof Item) {
		Item new_name = (Item) o;
		return this.itemcode.equals(new_name.itemcode);
	}
	return false;
}






}
