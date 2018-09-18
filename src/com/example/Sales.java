package com.example;

public class Sales {
	public Sales(float price, float discount) {
		super();
		this.price = price;
		this.discount = discount;
	}

	float price , discount;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
}
