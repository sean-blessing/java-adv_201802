package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Console;

public class WizardInventoryHashMapApp {

	public static void main(String[] args) {
		System.out.println("The Wizard Inventory game");
		Map<Integer, String> inventory = new HashMap<>();
		inventory.put(1, "wooden staff");
		inventory.put(2, "wizard hat");
		inventory.put(3, "cloth shoes");
		
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
				for (Map.Entry item: inventory.entrySet()) {
					System.out.println(item.getKey() +". "+item.getValue());
				}
			}
			else if (command.equalsIgnoreCase("grab")) {
				if (inventory.size() >=4) {
					System.out.println("too many items.  must drop one first.");
				}
				else {
					int n = Console.getInt("Number: ");
					String s = Console.getString("Name: ");
					inventory.put(n,s);
				}
			}
			else if (command.equalsIgnoreCase("edit")) {
				int n = Console.getInt("Number: ",0, inventory.size()+1);
				String s = Console.getString("Updated name: ");
				inventory.put(n, s);
				System.out.println("Item # "+n+" was updated");
			}
			else if (command.equalsIgnoreCase("drop")) {
				int n = Console.getInt("Number: ",0, inventory.size()+1);
				String s = inventory.get(n);
				inventory.remove(n);
				System.out.println(s+" was dropped.");
			}
		}
		
		
		
		
		System.out.println("Bye");

	}

}
