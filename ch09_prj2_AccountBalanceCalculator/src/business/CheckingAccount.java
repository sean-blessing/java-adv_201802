package business;

public class CheckingAccount extends Account {
	private double monthlyFee;
	
	public CheckingAccount(double balance, double monthlyFee) {
		setBalance(balance);
		this.monthlyFee = monthlyFee;
	}

	public void subtractFeeFromBalance() {
		setBalance(getBalance() - monthlyFee);
	}
	
	public double getMonthlyFee() {
		return monthlyFee;
	}
}
