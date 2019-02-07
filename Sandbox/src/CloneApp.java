
public class CloneApp {

	public static void main(String[] args) {
		System.out.println("hello");
		
		Product p1 = new Product("test", "testme", 10);
		System.out.println("p1 = "+p1);
		
		Product p2 = null;
		try {
			p2 = (Product) p1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("p2 = "+p2);

		System.out.println("bye");
	}

}
