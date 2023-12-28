package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	

	private int minimumBalance;
	
	public SavingsMaxAccount(String productCode, String productName, ArrayList<Service> productServices,
			int minimumBalance) {
		super(productCode, productName, productServices);
		this.minimumBalance = minimumBalance;
	}

	public int getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	@Override
	public String toString() {
		return "SavingsMaxAccount [minimumBalance=" + minimumBalance + ", getProductCode()=" + getProductCode()
				+ ", getProductName()=" + getProductName() + ", getProductServices()=" + getProductServices()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	

	
	
}
