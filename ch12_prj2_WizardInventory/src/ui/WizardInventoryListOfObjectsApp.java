package ui;

import java.util.ArrayList;
import java.util.List;

import business.WizardItem;
import util.Console;

public class WizardInventoryListOfObjectsApp {

	public static void main(String[] args) {
		System.out.println("The Wizard Inventory game");
		List<WizardItem> inventory = new ArrayList<>();
		inventory.add(new WizardItem("wooden staff"));
		inventory.add(new WizardItem("wizard hat"));
		inventory.add(new WizardItem("cloth shoes"));
		
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
				for (WizardItem wi: inventory) {
					System.out.println(wi.getId() +". "+wi.getName());
				}
			}
			else if (command.equalsIgnoreCase("grab")) {
				if (inventory.size() >=4) {
					System.out.println("too many items.  must drop one first.");
				}
				else {
					String s = Console.getString("Name: ");
					WizardItem wi = new WizardItem(s);
					inventory.add(wi);
				}
			}
			else if (command.equalsIgnoreCase("edit")) {
				int n = Console.getInt("Number: ",0, WizardItem.nextId);
				WizardItem wi = getItem(inventory, n);
				String s = Console.getString("Updated name: ");
				wi.setName(s);
				System.out.println("Item # "+n+" was updated");
			}
			else if (command.equalsIgnoreCase("drop")) {
				int n = Console.getInt("Number: ",0, WizardItem.nextId);
				WizardItem wi = getItem(inventory, n);
				inventory.remove(wi);
				System.out.println(wi.getName()+" was dropped.");
			}
		}
		
		
		
		
		System.out.println("Bye");

	}

	private static WizardItem getItem(List<WizardItem> list, 
										int itemNumber) {
		WizardItem wi = null;
		for (WizardItem item: list) {
			if(item.getId() == itemNumber) {
				wi = item;
			}
		}
		
		return wi;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
