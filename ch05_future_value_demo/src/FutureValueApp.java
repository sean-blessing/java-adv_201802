import java.util.Scanner;

public class FutureValueApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter monthly pmt:  ");
		int amt = sc.nextInt();
		System.out.println("Enter term (years):  ");
		int term = sc.nextInt();
		System.out.println("Enter annual interest rate:  ");
		int rate = sc.nextInt();
		
		double futureValue = FutureValueUtil.calculateFutureValue(amt, term, rate);
		System.out.println("future value = "+futureValue);

		System.out.println("Bye");
	}

}
