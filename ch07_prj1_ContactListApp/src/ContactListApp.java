
public class ContactListApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the contact list app");

		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			String fn = Console.getString("Enter first name: ");
			String ln = Console.getString("Enter last name:  ");
			String email = Console.getString("Enter email:  ");
			String phone = Console.getString("Enter phone:  ");
			// do our business logic
			// creating an instance of Contact
			Contact c = new Contact(fn,ln,email,phone);
			
			// display results
			System.out.println(c.displayContact());

			choice = Console.getString("Continue? (y/n): ");
		}

		System.out.println("Bye");

	}

}
