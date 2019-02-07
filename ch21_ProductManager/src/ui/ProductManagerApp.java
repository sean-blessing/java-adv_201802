package ui;

import java.sql.SQLException;
import java.util.List;

import business.Product;
import db.DAO;
import db.ProductDB;
import util.Console;

public class ProductManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Product Manager App");
		DAO<Product> pdb = new ProductDB();
		String command = "";
		while (!command.equalsIgnoreCase("x")) {
			displayMenu();
			command = Console.getString("Command: ");
			if (command.equalsIgnoreCase("1")) {
				// show all products
				try {
					List<Product> pdts = pdb.getAll();
					for (Product p: pdts) {
						System.out.println(p);
					}
				} catch (SQLException e) {
					System.out.println("Error occurred while getting all products.");
					e.printStackTrace();
				}
			}
			else if (command.equalsIgnoreCase("2")) {
				// get pdt by code
				String code = Console.getString("Enter product code:  ");
				try {
					Product pdt = pdb.get(code);
					System.out.println(pdt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (command.equalsIgnoreCase("3")) {
				// get pdt by id
				int id = Console.getInt("Enter product id:  ");
				try {
					Product pdt = pdb.get(id);
					System.out.println(pdt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (command.equalsIgnoreCase("4")) {
				// add a product
				String code = Console.getString("Enter product code: ");
				String description = Console.getString("Enter product desc: ");
				double price = Console.getDouble("Enter product price: ");
				Product pdt = new Product(code, description, price);
				try {
					if(pdb.add(pdt)) {
						System.out.println("product add success!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (command.equalsIgnoreCase("5")) {
				// update a product
				int id = Console.getInt("Enter id for product to update: ");
				try {
					Product pdt = pdb.get(id);
					String newDesc = Console.getString("Enter new description: ");
					pdt.setDescription(newDesc);
					if (pdb.update(pdt)) {
						System.out.println("Update success!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (command.equalsIgnoreCase("6")) {
				// delete a product
				int id = Console.getInt("Enter id for product to delete: ");
				try {
					Product pdt = pdb.get(id);
					if (pdb.delete(pdt)) {
						System.out.println("Delete success!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else  {
				System.out.println("Invalid command.  Try again.");
			}


		}
		
		
		System.out.println("Bye");

	}

	private static void displayMenu() {
		System.out.println("COMMAND MENU:");
		System.out.println("1 - show all products");
		System.out.println("2 - get product by code");
		System.out.println("3 - get product by id");
		System.out.println("4 - add a product");
		System.out.println("5 - edit product");
		System.out.println("6 - delete product");
		System.out.println("x - exit the app");
	}
	


}
