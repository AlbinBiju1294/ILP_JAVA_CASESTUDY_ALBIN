package com.ilp.utility;
import java.util.ArrayList;
import java.util.Scanner;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.CreateProductBankService;
import com.ilp.service.CreateServicesBankService;
import com.ilp.service.DisplayCustomerBankService;
import com.ilp.service.ManageAccountBankService;
import com.ilp.service.createCustomerBankService;

public class BankUtility {

	public static void main(String[] args) {
		int choice;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		do {
			System.out.println("\n\nEnter your choice");
			System.out.println("1. Create Service\n2.Create Product\n3.Create Customer\n4.Manage Acoounts\n5.Display Customer\n6.Exit");
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1:
					CreateServicesBankService.createService(serviceList);
					break;
				case 2:
					CreateProductBankService.createProduct(productList,serviceList);
					break;
				case 3:
					createCustomerBankService.createCustomer(customerList,productList);
					break;
				case 4:
					ManageAccountBankService.manageAccount(customerList);
					break;
				case 5:
					DisplayCustomerBankService.displayCustomer(customerList);
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid");
					
			}
			
		}while(choice<=5);
		
		scanner.close();

	}

}
