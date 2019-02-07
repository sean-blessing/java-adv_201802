import java.text.NumberFormat;

public class TernaryOperatorDemoApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		String input = Console.getString("Enter a sentence:  ");
		
		String gtlt = input.length() > 20 ? "greater" : "less";
		
		System.out.println("Sentence is "+gtlt + " than 20 characters long.");

		double subtotal = Console.getDouble("Enter the line item sub-total: ");
		
		double discPct = subtotal >= 500 ? .10 : .05;
		double discAmt = subtotal*discPct;
		double total = subtotal - discAmt;
		
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		NumberFormat pf = NumberFormat.getPercentInstance();
		System.out.println("The subtotal entitles you to a "+ pf.format(discPct) + " discount.\n"
				+"Your discount is "+ cf.format(discAmt) + ".\n"			
				+"Your total is "+cf.format(subtotal*(1-discPct)));
		System.out.println("Bye");
	}

}
