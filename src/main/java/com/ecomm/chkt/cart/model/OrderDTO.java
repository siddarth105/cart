package com.ecomm.chkt.cart.model;

import java.util.List;

public class OrderDTO {
	
	private int orderId;
	private List<ItemDTO> itemList;
	private String status;
	
	public OrderDTO(int orderId, List<ItemDTO> itemList, String status) {
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
	public List<ItemDTO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
