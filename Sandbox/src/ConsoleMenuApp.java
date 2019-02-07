
public class ConsoleMenuApp {

	public static void main(String[] args) {
		System.out.println("Hello");

		String choice = "";
		while (!choice.equalsIgnoreCase("exit")) {
			displayMenu();
			choice = Console.getString("Enter option:  ");
			
			if (choice.equalsIgnoreCase("1")) {
				
			}
			else if (choice.equalsIgnoreCase("2")) {
				
			}
		}
			
		System.out.println("Bye");
	}

	private static void displayMenu() {
		System.out.println("Menu:");
		System.out.println("1 - List users");
		System.out.println("2 - add user");
		System.out.println("3 - update user");
		System.out.println("4 - delete user");
		System.out.println("exit - exit app");
	}

}
