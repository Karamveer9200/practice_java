package CS_110;

import java.util.Scanner;

public class C6DoubleMoney {

    //Interest rate as a %
    static final double INTEREST_RATE = 3.0;
    //Convert interest rate into amount to multiply money by
    static final double MULTIPLIER = 1 + INTEREST_RATE/100;

    //Message strings for communicating with user
    static final String AMOUNT_PROMPT = "Enter amount: ";
    static final String OUTPUT_MSG = "Years to double €%.2f at %.1f%%: %d years";

    public static void main(String [] args) {

        //Get user input
        Scanner in = new Scanner(System.in);
        System.out.print(AMOUNT_PROMPT);
        double initialAmount = in.nextDouble(); //initial amount of money


		/* This loop will continue until the initial amount has doubled,
		keeping track of the number of years*/
        double balance = initialAmount;
        int year = 0;
        while (balance < initialAmount * 2) {
            balance *= MULTIPLIER;
            year++;
        }

        //Amount details
        System.out.println(String.format(OUTPUT_MSG,
                initialAmount, INTEREST_RATE, year));
    }
}