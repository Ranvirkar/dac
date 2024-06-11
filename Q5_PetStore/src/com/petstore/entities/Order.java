package com.petstore.entities;

import java.util.Objects;

public class Order {
	private static int count = 0;
	private int orderId;
	private int petid;
	private int quantity;
	private Status status;

	public Order() {
		super();
	}

	public Order( int petid, int quantity) {
		super();
		this.orderId = ++count;
		this.petid = petid;
		this.quantity = quantity;
		this.status = Status.PLACED;
	}



	public int getOrderId() {
		return orderId;
	}

	public int getPetid() {
		return petid;
	}

	public int getQuantity() {
		return quantity;
	}

	public Status getStatus() {
		return status;
	}

	public static void setCount(int count) {
		Order.count = count;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setPetid(int petid) {
		this.petid = petid;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petid=" + petid + ", quantity=" + quantity + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return this.orderId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order) {
			Order new_name = (Order) obj;
			return this.orderId == new_name.orderId;
		}
		return false;
	}

}
