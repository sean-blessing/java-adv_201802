package business;

public class SavingsAccount extends Account {
	private double monthlyInterestRate;
	private double monthlyInterestPayment;
	
	public SavingsAccount(double balance, double monthlyInterestRate) {
		setBalance(balance);
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	public void applyPaymentToBalance() {
		monthlyInterestPayment = getBalance() * monthlyInterestRate;
		setBalance(getBalance() + monthlyInterestPayment);
	}
	
	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}
}
