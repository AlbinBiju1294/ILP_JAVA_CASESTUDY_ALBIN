package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Service;

public class DisplayCustomerBankService {

	public static void displayCustomer(ArrayList<Customer> customerList) {
		
		String customerId;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer id:");
		customerId = scanner.next();
		for(Customer customer: customerList)
		{
			if(customer.getCustomerCode().equals(customerId))
			{
				System.out.println("************************Customer Account Details****************************");
				System.out.println("Customer_id\t\tCustomer_name\t\tAccount_Type\t\tBalance");
				System.out.println("****************************************************************************");
				
				ArrayList<Account> accountList = customer.getAccountList();
				for(Account account:accountList)
				{
					System.out.println(customer.getCustomerCode()+"\t\t\t"+customer.getCustomerName()+"\t\t\t"+account.getAccountType()+"\t\t"+account.getBalanceAmount());
					System.out.print("Services provided:");
					ArrayList<Service> serviceList = account.getProduct().getProductServices();
					for(Service service:serviceList)
					{
						System.out.print(service.getServiceName()+",");
					}
					System.out.println();
					
				}
			}
		}
		
	}

}
