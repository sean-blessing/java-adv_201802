import java.text.NumberFormat;

public class Product {
	private String code;
	private String description;
	private double price;
	private static int objectCount = 0;
	
	public Product() {
		objectCount++;
	}

	public Product(String c, String d, double p) {
		code = c;
		description = d;
		price = p;
		objectCount++;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getPriceFormatted() {
		String pf = "";
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		pf = currencyFormat.format(price);
		return pf;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description 
				+ ", price=" + getPriceFormatted() + ", count = "+objectCount+"]";
	}
	
	
	

}
