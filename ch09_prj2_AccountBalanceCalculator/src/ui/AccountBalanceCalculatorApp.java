package ui;

import business.Account;
import business.CheckingAccount;
import business.SavingsAccount;
import util.Console;

public class AccountBalanceCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Account application");
		CheckingAccount ca = new CheckingAccount(1000.0, 1.0);
		SavingsAccount sa = new SavingsAccount(1000.0, .01);
		
		System.out.println("Starting Balances:");
		displayAccountBalances(ca, sa);
		
		System.out.println("Enter the transactions for the month");
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			String transType = Console.getString("Withdrawal or deposit? (w/d): ", "w", "d");
			String acctType = Console.getString("Checking or Savings (c/s): ", "c", "s");
			double amount = 0;
			while (true) {
				amount = Console.getDouble("Amount? ", 0, Double.POSITIVE_INFINITY);
				double balance = 0;
				if (acctType.equalsIgnoreCase("c"))
					balance = ca.getBalance();
				else 
					balance = sa.getBalance();
				if (transType.equalsIgnoreCase("w")&& (amount > balance)) {
					System.out.println("Amount cannot exceed balance!  Try again.");
					continue;
				}
				else {
					break;
				}
					
			}
			processTransaction(ca, sa, transType, acctType, amount);
			choice = Console.getString("Continue (y/n)? ", "y", "n"); 
		}
		
		sa.applyPaymentToBalance();
		ca.subtractFeeFromBalance();
		
		System.out.println("Monthly Payments and Fees");
		System.out.println("Checking Fee:              "+ca.getMonthlyFee());
		System.out.println("Savings interest payment:  "+sa.getMonthlyInterestPayment());
		
		System.out.println("Final Balances:");
		displayAccountBalances(ca, sa);
		System.out.println("Bye");

	}
	
	private static void processTransaction(CheckingAccount ca, SavingsAccount sa, 
											String transType, String acctType, double amt) {
		Account acct = null;
		
		if (acctType.equalsIgnoreCase("c")) {
			acct = ca;
		}
		else {
			acct = sa;
		}
		
		if (transType.equalsIgnoreCase("w")) {
			acct.withdraw(amt);
		}
		else {
			acct.deposit(amt);
		}
	}
	private static void displayAccountBalances(CheckingAccount ca, SavingsAccount sa) {
		System.out.println("CheckingAccount:  "+ca.getBalanceFormatted());
		System.out.println("SavingsAccount:   "+sa.getBalanceFormatted());
	}

}
