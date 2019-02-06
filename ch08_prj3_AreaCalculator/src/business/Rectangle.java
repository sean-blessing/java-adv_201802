package business;

public class Rectangle extends Square {
	private double length;

	public Rectangle(double width, double length) {
		super(width);
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double getArea() {
		return length * getWidth();
	}
	
}
