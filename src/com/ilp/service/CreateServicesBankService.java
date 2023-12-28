package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Service;

public class CreateServicesBankService {

	public static void createService(ArrayList<Service> serviceList) {

		Scanner scanner = new Scanner(System.in);
		char continueChoice = 'y';
		String serviceCode;
		String serviceName;
		double serviceRate;
		do {
			System.out.print("Enter the service code: ");
			serviceCode = scanner.next();
			System.out.print("Enter the service name: ");
			serviceName = scanner.next();
			System.out.print("Enter the service Rate: ");
			serviceRate = scanner.nextDouble();
			Service service = new Service(serviceCode,serviceName,serviceRate);
			serviceList.add(service);
			System.out.println("Do you want to add more service (y/n) :");
			continueChoice = scanner.next().charAt(0);
			
		}while(continueChoice == 'y');
		
	}
	
}
