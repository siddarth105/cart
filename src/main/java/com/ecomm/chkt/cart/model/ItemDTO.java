package com.ecomm.chkt.cart.model;

public class ItemDTO {

	private int itemId;

	private String itemName;
	
	public ItemDTO(int itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}

	public ItemDTO() {}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
