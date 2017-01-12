package com.main;

public class Account {

	private double limit = 0;
	
	public double getMoney() {
		return limit;
	}

	public void deposit(double d) {
		
		this.limit += d;
	}

	public void inposit(double i) {

		if (this.limit < i)
		{
			throw new IllegalArgumentException("Not Enough Money");
		}
		this.limit -= i;
	}

}
