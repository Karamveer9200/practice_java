import java.util.Scanner;

/**
 * This is the first version of CardNames and it doesn't compile:-)
 * Don't use this one.
 */

class CardNames1 {
	public static void main(String[] args) {
		final String[] CARD_NAMES={"Ace", "Two", "Three", "Four", "Five", "Six",
									"Seven", "Eight", "Nine", "Ten","Jack",
									"Queen", "King"};
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a number between 1 and " + CARD_NAMES.length + ": ");
		int cardVal = in.nextInt();
		
		System.out.println("That's a " + getCardName(cardVal));
	}
	
	public static String getCardName(int val) {
		return CARD_NAMES[val - 1];
	}
}