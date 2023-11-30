import java.util.Scanner;

/**
 * This is the third version of CardNames and it does compile because we move CARD_NAMES outside main()
 * This is the nearest we can get to in Java to a *global variable* - so far all the variables we have
 * seen are in some way *local* because they are limited to the {...} block they are in. If you have
 * done any programming before you may have been told 'global variables are bad'. Generally we prefer to
 * limit variables to the smallest block we can - but in this case if you are going to use CARD_NAMES a lot
 * it might be clearer to do it like this.
 */

class CardNames3 {
	
	//For reasons that will be clear later in the module we have added static
	final static String[] CARD_NAMES={"Ace", "Two", "Three", "Four", "Five", "Six",
									"Seven", "Eight", "Nine", "Ten","Jack",
									"Queen", "King"};


	public static void main(String[] args) {
				
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a number between 1 and " + CARD_NAMES.length + ": ");
		int cardVal = in.nextInt();
		
		System.out.println("That's a " + getCardName(cardVal));
	}
	
	//We don't need CARD_NAMES as a parameter anymore
	public static String getCardName(int val) {
		return CARD_NAMES[val - 1];
	}
}
