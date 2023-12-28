package com.ilp.entity;

public class Account {
	private String accountNo;
	private String accountType;
	private double balanceAmount;
	private Product product;
	
	
	public Account(String accountNo, String accountType, double balanceAmount, Product product) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.balanceAmount = balanceAmount;
		this.product = product;
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", balanceAmount=" + balanceAmount
				+ ", product=" + product + "]";
	}
	
	
	
	
}
