package ui;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class WizardInventoryApp {

	public static void main(String[] args) {
		System.out.println("The Wizard Inventory game");
		List<String> inventory = new ArrayList<>();
		inventory.add("wooden staff");
		inventory.add("wizard hat");
		inventory.add("cloth shoes");
		
		String command = "";
		
		while (!command.equalsIgnoreCase("exit")) {
			System.out.println("COMMAND MENU:");
			System.out.println("show - show all items");
			System.out.println("grab - add an item to inventory");
			System.out.println("edit - edit an item from inventory");
			System.out.println("drop - remove an item from inventory");
			System.out.println("exit - exit the app");
			
			command = Console.getString("Command: ");
			
			if (command.equalsIgnoreCase("show")) {
				for (int i = 0; i< inventory.size(); i++) {
					System.out.println(i +". "+inventory.get(i));
				}
			}
			else if (command.equalsIgnoreCase("grab")) {
				if (inventory.size() >=4) {
					System.out.println("too many items.  must drop one first.");
				}
				else {
					String s = Console.getString("Name: ");
					inventory.add(s);
				}
			}
			else if (command.equalsIgnoreCase("edit")) {
				int n = Console.getInt("Number: ",-1, inventory.size());
				String s = Console.getString("Updated name: ");
				inventory.set(n, s);
				System.out.println("Item # "+n+" was updated");
			}
			else if (command.equalsIgnoreCase("drop")) {
				int n = Console.getInt("Number: ",-1, inventory.size());
				String s = inventory.get(n);
				inventory.remove(n);
				System.out.println(s+" was dropped.");
			}
		}
		
		
		
		
		System.out.println("Bye");

	}

}
