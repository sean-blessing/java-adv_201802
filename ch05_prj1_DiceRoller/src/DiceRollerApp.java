
public class DiceRollerApp {

	public static void main(String[] args) {
		System.out.println("Dice Roller");
		
		String choice = Console.getString("Roll the dice (y/n)?  ");
		while (choice.equalsIgnoreCase("y")) {
			int d1 = rollDie();
			int d2 = rollDie();
			int sum = d1 + d2;
			System.out.println(getDiceSummary(d1, d2, sum));
			System.out.println();
			choice = Console.getString("Roll again (y/n)?  ");
		}
		
		System.out.println("Bye!");

	}
	
	private static int rollDie() {
		int d = (int) (Math.random() * 6) + 1;
		return d;
	}
	
	private static String getDiceSummary(int d1, int d2, int total) {
		StringBuilder sb = new StringBuilder();
		sb.append("Die 1: "+d1+"\n");
		sb.append("Die 2: "+d2+"\n");
		sb.append("Total: "+total);
		if (total==2)
			sb.append("\nSnake eyes!!!");
		else if (total==12) {
			sb.append("\nBox cars!!");
		}
		
		return sb.toString();
	}

}
