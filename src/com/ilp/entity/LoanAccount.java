package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	
	private double chequeDeposit;

	public LoanAccount(String productCode, String productName, ArrayList<Service> productServices,
			double chequeDeposit) {
		super(productCode, productName, productServices);
		this.chequeDeposit = chequeDeposit;
	}

	public double getChequeDeposit() {
		return chequeDeposit;
	}

	public void setChequeDeposit(double chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}

	@Override
	public String toString() {
		return "LoanAccount [chequeDeposit=" + chequeDeposit + ", getProductCode()=" + getProductCode()
				+ ", getProductName()=" + getProductName() + ", getProductServices()=" + getProductServices()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
