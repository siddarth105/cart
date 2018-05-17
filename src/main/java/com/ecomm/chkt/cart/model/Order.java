package com.ecomm.chkt.cart.model;

import java.util.List;

public class Order {
	
	private int orderId;
	private List<Item> itemList;
	private String status;
	
	public Order(int orderId, List<Item> itemList, String status) {
		super();
		this.orderId = orderId;
		this.itemList = itemList;
		this.status = status;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
