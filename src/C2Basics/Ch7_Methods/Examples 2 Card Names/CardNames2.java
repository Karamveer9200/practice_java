import java.util.Scanner;

/**
 * This is the second version of CardNames and it does compile because we pass CARD_NAMES as a parameter
 * This one is OK to use - but what if you have lots of other methods that need to use CARD_NAMES? You will
 * end up passing lots of parameters that all refer to something that is common to them, and which is final
 * so will never change. We can avoid this with version 3.
 */

class CardNames2 {
	public static void main(String[] args) {
		final String[] CARD_NAMES={"Ace", "Two", "Three", "Four", "Five", "Six",
									"Seven", "Eight", "Nine", "Ten","Jack",
									"Queen", "King"};
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a number between 1 and " + CARD_NAMES.length + ": ");
		int cardVal = in.nextInt();
		
		System.out.println("That's a " + getCardName(cardVal, CARD_NAMES));
	}
	
	public static String getCardName(int val, String[] cardArray) {
		return cardArray[val - 1];
	}
}

/* Why isn't cardArray in caps? */