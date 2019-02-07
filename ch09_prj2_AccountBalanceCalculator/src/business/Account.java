package business;

import java.text.NumberFormat;

public class Account implements Withdrawable, Balanceable, Depositable {

	private double balance;
	
	@Override
	public void deposit(double amt) {
		balance += amt;

	}

	@Override
	public double getBalance() {
		return balance;
	}

	public String getBalanceFormatted() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return nf.format(balance);
	}

	@Override
	public void setBalance(double amt) {
		balance = amt;

	}

	@Override
	public void withdraw(double amt) {
		balance -= amt;
	}

}
