package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;

public class createCustomerBankService {

	public static void createCustomer(ArrayList<Customer> customerList, ArrayList<Product> productList) {

		if(productList.isEmpty())
		{
			System.out.println("Cannot add customer, add products");
		}
		else
		{
			ArrayList<Account> accountList = null;  
			int concatNumber = 1;
			Customer customer = null;
			char accountContinueChoice = 'y';
			Scanner scanner = new Scanner(System.in);
			String customerCode;
			String customerName;
			System.out.println("Enter the customer code :");
			customerCode = scanner.next();
			boolean flag = true;
			for(Customer customer1: customerList)
			{
				if(customer1.getCustomerCode().equals(customerCode))
				{
					customer = customer1;
					flag = false;
				}
			}
			if(flag)
			{
				accountList = new ArrayList<Account>();
				System.out.println("Customer id not available: Create a new account");
				System.out.println("Enter the customer code:");
				customerCode = scanner.next();
				System.out.println("Enter the customer name:");
				customerName = scanner.next();
				do {
					System.out.println("*************Accounts Available****************");
					int i = 1;
					for(Product product:productList)
					{
						System.out.println(i+". "+product.getProductName());
						i++;
					}
					int accountChoice = scanner.nextInt();
					System.out.println("Enter the balance amount");
					double balanceAmount = scanner.nextDouble();
					Account account = new Account("AC00"+concatNumber,productList.get(accountChoice-1).getProductName(),balanceAmount,productList.get(accountChoice-1));
					concatNumber++;
					accountList.add(account);
					System.out.println("Do you want to add more account(y/n)");
					accountContinueChoice = scanner.next().charAt(0);
				}while(accountContinueChoice == 'y' || accountContinueChoice == 'Y');
				customer = new Customer(customerCode,customerName,accountList);
				customerList.add(customer);
			}
			else
			{
				accountList = customer.getAccountList();
				do {
					System.out.println("*************Accounts Available****************");
					int i = 1;
					for(Product product:productList)
					{
						System.out.println(i+". "+product.getProductName());
						i++;
					}
					int accountChoice = scanner.nextInt();
					System.out.println("Enter the balance amount");
					double balanceAmount = scanner.nextDouble();
					Account account = new Account("AC00"+concatNumber,productList.get(accountChoice-1).getProductName(),balanceAmount,productList.get(accountChoice-1));
					concatNumber++;
					accountList.add(account);
					System.out.println("Do you want to add more account(y/n)");
					accountContinueChoice = scanner.next().charAt(0);
				}while(accountContinueChoice == 'y' || accountContinueChoice == 'Y');
				customer.setAccountList(accountList);
			}
			
			
		}
		
	}

}
