package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;

public class ManageAccountBankService {

	public static void manageAccount(ArrayList<Customer> customerList) {
		
		Scanner scanner = new Scanner(System.in);
		Customer currentCustomer = null;
		String customerId;
		System.out.println("Enter the customer id");
		customerId =  scanner.next();
		boolean flag = false;
		for(Customer customer: customerList)
		{
			if(customer.getCustomerCode().equals(customerId))
			{
				flag = true;
				currentCustomer = customer;
				break;
			}
		}
		if(flag)
		{
			String accountNo;
			System.out.println(currentCustomer.getCustomerName()+" has the following accounts:");
			for(Account account: currentCustomer.getAccountList())
			{
				System.out.println(account.getAccountNo()+"  "+account.getAccountType());
			}
			System.out.println("Enter the account number");
			accountNo = scanner.next();
			Account activeAccount = null;
			for(Account account: currentCustomer.getAccountList())
			{
				if(account.getAccountNo().equals(accountNo))
				{
					activeAccount = account;
					break;
				}
			}
			char transactionContinueChoice = 'y';
			do {
				System.out.println("Enter your choice:");
				System.out.println("1.Deposit Money\n2.Withdraw Money\n3.Display Balance");
				int transactionChoice = scanner.nextInt();
				double balanceMoney;
				switch(transactionChoice)
				{
					case 1:
						System.out.println("Enter the amount to deposit:");
						double depositAmount = scanner.nextDouble();
						depositMoney(activeAccount,depositAmount);
						break;
					case 2:
						if(activeAccount.getProduct() instanceof LoanAccount)
							System.out.println("Cannot withdraw from loan account");
						else
						{
							boolean success;
							do {
								System.out.println("Enter the amount to withdraw:");
								double withdrawAmount = scanner.nextDouble();
								success = withdrawMoney(activeAccount,withdrawAmount);
							}while(!success);
							
							
						}
//						System.out.println("Enter the amount to withdraw:");
//						double withdrawAmount = scanner.nextDouble();
//						balanceMoney = activeAccount.getBalanceAmount()-withdrawAmount;
//						if(activeAccount.getAccountType().equals("savingsmaxaccount"))
//						{
//							if(balanceMoney < ((SavingsMaxAccount)activeAccount.getProduct()).getMinimumBalance())
//							{
//								System.out.println("Withdrawal blocked due to insufficient balance\nMinimum balance of "+ ((SavingsMaxAccount)activeAccount.getProduct()).getMinimumBalance()+" should be maintained");
//								System.out.println("Your current balance is: "+activeAccount.getBalanceAmount());
//								System.out.println("Do you want to continue withdraw(y/n)");
//								char withdrawChoice = scanner.next().charAt(0);
//								if(withdrawChoice == 'y')
//								{
//									System.out.println("Enter the withdrawal amount:");
//									withdrawAmount = scanner.nextDouble();
//									activeAccount.setBalanceAmount(activeAccount.getBalanceAmount()-withdrawAmount);
//								}
//								else
//								{
//									break;
//								}
//								
//								
//							}
//							else
//							{
//								activeAccount.setBalanceAmount(activeAccount.getBalanceAmount()-withdrawAmount);
//								break;
//							}
//							
//						}
//						else
//						{
//							activeAccount.setBalanceAmount(activeAccount.getBalanceAmount()-withdrawAmount);
//							break;
//						}
					case 3:
						System.out.println("Your balance amount: "+activeAccount.getBalanceAmount());
						break;
					default:
						System.out.println("Invalid");
						
				}
				System.out.println("Do you want to continue:(y/n)");
				transactionContinueChoice = scanner.next().charAt(0);
			}while(transactionContinueChoice == 'y' || transactionContinueChoice == 'Y');
			
		}
		
	}

	private static boolean withdrawMoney(Account activeAccount, double withdrawAmount) {
		
		if(activeAccount.getProduct() instanceof SavingsMaxAccount)
		{
			SavingsMaxAccount smAccount = (SavingsMaxAccount)activeAccount.getProduct();
			if((activeAccount.getBalanceAmount()-withdrawAmount)<smAccount.getMinimumBalance())
			{
				return false;
			}
			else
			{
				activeAccount.setBalanceAmount(activeAccount.getBalanceAmount()-withdrawAmount);
				return true;
			}
		}
		else
		{
			if((activeAccount.getBalanceAmount()-withdrawAmount)<0)
			{
				return false;
			}
			else
			{
				activeAccount.setBalanceAmount(activeAccount.getBalanceAmount()-withdrawAmount);
				return true;
			}
		}
	}

	private static void depositMoney(Account activeAccount, double depositAmount) {
		
		double balanceMoney;
		if(activeAccount.getProduct() instanceof LoanAccount)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n1.Cash Deposit\n2.Cheque Deposit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			if(choice == 2)
			{
				double deductAmount = depositAmount * (((LoanAccount)activeAccount.getProduct()).getChequeDeposit()/100);
				depositAmount = depositAmount-deductAmount;
			}
			balanceMoney = activeAccount.getBalanceAmount()+depositAmount;
			activeAccount.setBalanceAmount(balanceMoney);
		}
		else
		{
			balanceMoney = activeAccount.getBalanceAmount()+depositAmount;
			activeAccount.setBalanceAmount(balanceMoney);
		}
		
	}

}
