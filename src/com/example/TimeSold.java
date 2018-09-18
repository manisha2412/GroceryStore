package com.example;

public class TimeSold {
	public TimeSold(int today, int yesterday) {
		super();
		this.today = today;
		this.yesterday = yesterday;
	}

	int today, yesterday;

	public int getToday() {
		return today;
	}

	public void setToday(int today) {
		this.today = today;
	}

	public int getYesterday() {
		return yesterday;
	}

	public void setYesterday(int yesterday) {
		this.yesterday = yesterday;
	}
	
}
