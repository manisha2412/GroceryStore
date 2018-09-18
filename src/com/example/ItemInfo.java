package com.example;

public class ItemInfo {
	public ItemInfo(String description, String category) {
		super();
		this.description = description;
		this.category = category;
	}

	String description, category;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
