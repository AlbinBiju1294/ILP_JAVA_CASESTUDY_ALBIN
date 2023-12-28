package com.ilp.entity;

import java.util.ArrayList;

public class CurrentAccount extends Product {

	public CurrentAccount(String productCode, String productName, ArrayList<Service> productServices) {
		super(productCode, productName, productServices);
	}

	@Override
	public String toString() {
		return "CurrentAccount [getProductCode()=" + getProductCode() + ", getProductName()=" + getProductName()
				+ ", getProductServices()=" + getProductServices() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
