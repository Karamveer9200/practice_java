/* The Say Lemon Pro game - all the excitment of the old one but less repeated code */

import java.util.Scanner;

public class SayLemonPro {
	
	//Why is this here? Why is it static? Find out soon...
	static Scanner in = new Scanner(System.in);
		
	public static void main(String[] args) {
		
		String again;
		String playAgain;
		
		do {
			System.out.println("Welcome to Say Lemon");
			do {
				System.out.println("Yay!!! Say Lemon!!");
			}while(positiveResponse("Again? Type Lemon for yes, Kiwi for no ",
				"lemon", "kiwi"));
		} while(positiveResponse("Play again (go on...). Type yes or no ", "yes", "no"));
	}
	
	//Method to printout a message and keep asking until the user types either the
	//postive
	//or negative strings (case does not matter). Returns true if positive,
	//false if negative
	public static boolean positiveResponse(String message, String positive,
		String negative) {
		String again;
		
		do {
			System.out.print(message);
			again = in.nextLine();
		} while(!again.equalsIgnoreCase(positive) && !again.equalsIgnoreCase(negative));
		
		return again.equalsIgnoreCase(positive);
	}
}