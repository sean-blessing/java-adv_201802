package ui;

import business.Circle;
import business.Rectangle;
import business.Shape;
import business.Square;
import util.Console;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the area calculator");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String shapeType = Console.getString("Calculate "
					+ "area of a circle, square, or rectangle? (c/s/r): ");
			Shape shape = null;
			
			if (shapeType.equalsIgnoreCase("c")) {
				// create a circle
				double radius = Console.getDouble("Enter radius: ",0,Double.POSITIVE_INFINITY);
				shape = new Circle(radius);
			}
			else if (shapeType.equalsIgnoreCase("s")) {
				// create a square
				double width = Console.getDouble("Enter width: ",0,Double.POSITIVE_INFINITY);
				shape = new Square(width);
			}
			else if (shapeType.equalsIgnoreCase("r")) {
				// create a rectangle
				double width = Console.getDouble("Enter width: ",0,Double.POSITIVE_INFINITY);
				double length = Console.getDouble("Enter length: ",0,Double.POSITIVE_INFINITY);
				shape = new Rectangle(width,length);
			}
			else {
				// invalid entry
				System.out.println("Invalid entry!  Try again.");
				continue;
			}
			
			String shapeString = shape.getClass().getSimpleName();
			System.out.println("The area of the "+ shapeString +" you entered is "+shape.getArea());
			
			
			choice = Console.getString("Continue? (y/n): ",
										"y","n");
		}
		
		System.out.println("Bye");
	}

}
