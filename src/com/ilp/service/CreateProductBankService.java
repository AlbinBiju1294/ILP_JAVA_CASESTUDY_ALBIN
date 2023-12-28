package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class CreateProductBankService {

	public static void createProduct(ArrayList<Product> productList, ArrayList<Service> serviceList) {

		if(serviceList.isEmpty())
		{
			System.out.println("Add services");
		}
		else
		{
			String productCode;
			String productName;
			char productContinueChoice = 'y';
			Scanner scanner  = new Scanner(System.in);
			char continueChoice;
			do {
				System.out.println("Enter the product code: ");
				productCode = scanner.next();
				System.out.println("Enter the product name: ");
				productName = scanner.next();
				ArrayList<Service> tempServiceList = new ArrayList<Service>();
				System.out.println("Select the services to add");
				do {
					
					int serviceChoice;
					int i = 1;
					for(Service service: serviceList)
					{
						System.out.println(i+". "+service.getServiceName());
						i++;
					}
					serviceChoice = scanner.nextInt();
					tempServiceList.add(serviceList.get(serviceChoice-1));
					System.out.println("Do you want to add more service to the product(y/n)");
					continueChoice = scanner.next().charAt(0);
					
				}while(continueChoice == 'y' || continueChoice == 'Y');
				
				switch(productName.toLowerCase())
				{
					case "savingsmaxaccount":
						SavingsMaxAccount savingsMaxAccount = new SavingsMaxAccount(productCode,productName,tempServiceList,1000);
						productList.add(savingsMaxAccount);
						break;
					case "currentaccount":
						CurrentAccount currentaccount = new CurrentAccount(productCode,productName,tempServiceList);
						productList.add(currentaccount);
						break;
					case "loanaccount":
						LoanAccount loanaccount = new LoanAccount(productCode,productName,tempServiceList,0.3);
						productList.add(loanaccount);
						break;
				}
				System.out.println("Do you want to add more products(y/n)");
				productContinueChoice = scanner.next().charAt(0);
			}while(productContinueChoice == 'y' || productContinueChoice == 'Y' );
		}
		
	}

}
