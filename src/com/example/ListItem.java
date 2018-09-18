package com.example;

public class ListItem {
	public ListItem(String name, long id, ItemInfo itemInfo, Sales sales, Internal internal) {
		super();
		this.name = name;
		this.id = id;
		this.itemInfo = itemInfo;
		this.sales = sales;
		this.internal = internal;
	}
	String name;
	long id;
	ItemInfo itemInfo;
	Sales sales;
	Internal internal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ItemInfo getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}
	public Sales getSales() {
		return sales;
	}
	public void setSales(Sales sales) {
		this.sales = sales;
	}
	public Internal getInternal() {
		return internal;
	}
	public void setInternal(Internal internal) {
		this.internal = internal;
	}
	
}
