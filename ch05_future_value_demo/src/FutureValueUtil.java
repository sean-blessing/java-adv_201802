
public class FutureValueUtil {
	public static int MONTHS_IN_A_YEAR = 12;
	// term will be in years, rate will be whole #
	public static double calculateFutureValue(
			double amt, int term, int rate) {
		double fv = 0.0;
		double monthlyInterestRate = ((double)rate/MONTHS_IN_A_YEAR)/100;
		int months = term*12;
		for (int i = 1; i <= months; i++) {
			fv = (fv+amt)*(1+monthlyInterestRate);
		}
		return fv;
	}
}
