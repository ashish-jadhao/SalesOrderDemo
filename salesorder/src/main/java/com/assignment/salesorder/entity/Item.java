package com.assignment.salesorder.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Item")
public class Item {

	@Id
	//@NotEmpty(message = "item id must not be empty")
	private Integer itemId;
	//@NotEmpty(message = "item name must not be empty")
	private String itenName;
	//@NotEmpty(message = "price must not be empty")
	private Integer itemPrice;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItenName() {
		return itenName;
	}
	public void setItenName(String itenName) {
		this.itenName = itenName;
	}
	public Integer getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itenName=" + itenName + ", itemPrice=" + itemPrice + "]";
	}
	
	
}
