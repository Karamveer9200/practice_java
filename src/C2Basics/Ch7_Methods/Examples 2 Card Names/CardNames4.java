import java.util.Scanner;

/**
 * This is the fourth version of CardNames and it does compile because we move CARD_NAMES inside getCardName()
 * This is the best way to do it *if* we only need CARD_NAMES *inside* getCardName. Notice that includes
 * the *length* of CARD_NAMES which we can't use outside either.
 */

class CardNames4d {
	
	//For reasons that will be clear later in the module we have added static
		public static void main(String[] args) {
				
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a number between 1 and 13: ");
		int cardVal = in.nextInt();
		
		System.out.println("That's a " + getCardName(cardVal));
	}
	
	//We don't need CARD_NAMES as a parameter anymore
	public static String getCardName(int val) {
		final  String[] CARD_NAMES={"Ace", "Two", "Three", "Four", "Five", "Six",
											"Seven", "Eight", "Nine", "Ten","Jack",
											"Queen", "King"};

		return CARD_NAMES[val - 1];
	}
}

/*
 * Which do we use? That's entirely dependent on what we are doing and, as you can see, there is
 * no 'perfect' solution in any case - they all have potential disadvantages so you need to weigh up
 * the pros and cons and use your judgement. Remember, that in nearly all programming. clarity and readability
 * are the most important thing.
 */
