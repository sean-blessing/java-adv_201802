
public class TableOfPowersApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Squares and Cubes table");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int n = Console.getInt("Enter an integer: ");
			String table = "Number\tSquared\tCubed\r\n" + 
					"======\t=======\t=====\n";
			for (int i = 1; i <= n; i++) {
				int s = i * i;
				int c = i * i * i;
				table += i + "\t" + s + "\t" + c + "\n";
			}
			System.out.println(table);
			choice = Console.getString("Continue (y/n)?  ");
		}
		
		
		System.out.println("Bye");
	}
}
