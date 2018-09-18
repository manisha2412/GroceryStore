package com.example;

public class Internal {
	public Internal(int aisle, TimeSold timeSold) {
		super();
		this.aisle = aisle;
		this.timeSold = timeSold;
	}
	int aisle;
	TimeSold timeSold;
	public int getAisle() {
		return aisle;
	}
	public void setAisle(int aisle) {
		this.aisle = aisle;
	}
	public TimeSold getTimeSold() {
		return timeSold;
	}
	public void setTimeSold(TimeSold timeSold) {
		this.timeSold = timeSold;
	}
}
