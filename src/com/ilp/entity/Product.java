package com.ilp.entity;

import java.util.ArrayList;

public abstract class Product {
	private String productCode;
	private String productName;
	private ArrayList<Service> productServices;
	
	
	
	public Product(String productCode, String productName, ArrayList<Service> productServices) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productServices = productServices;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ArrayList<Service> getProductServices() {
		return productServices;
	}
	public void setProductServices(ArrayList<Service> productServices) {
		this.productServices = productServices;
	}
	
	public void displayBalance(Account account)
	{
		System.out.println(account.getAccountNo()+" has balance amount: "+account.getBalanceAmount());
	}
	
}
