import java.util.Scanner;

public class ProductManagerApp {

	public static void main(String[] args) {
		System.out.println("Hello");

		Scanner sc  = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter product code:  ");
			String c = sc.next();
			System.out.print("Enter product description:  ");
			String d = sc.next();
			System.out.print("Enter product price:  ");
			double p = sc.nextDouble();
			Product pdt = new Product(c,d,p);
			System.out.println("New product = "+pdt.toString());
			
			System.out.println("Add another product (y/n) ? ");
			choice = sc.next();
		}
		System.out.println("Bye");
		sc.close();
	}

}
