package cs110.Assessment.Assessment1.Solutions;

import java.util.Scanner;

/*
Java program to play the game Fibonacci Nim to Level 4 - this version would get all marks *except* the exceptional ones
 */
public class FibonacciNimBasic {

    //Constants allow us to change heap sizes and messages without reading the code
    public static final int PILE_SIZE = 13;
    //Only change if you want to allow a different initial coin choice
    public static final int PILE_MAX_INITIAL_REMOVAL = PILE_SIZE - 1;
    public static final String PLAYER_1_HEAP_CHOICE_MSG = "Player 1: choose a heap: ";
    public static final String PLAYER_2_HEAP_CHOICE_MSG = "Player 2: choose a heap: ";
    public static final String REMAINING_COINS_MSG = "Remaining coins: %d, %d, %d\n";
    public static final String ILLEGAL_HEAP_CHOICE = "Sorry that's not a legal heap choice.";
    public static final String ILLEGAL_HEAP_RANGE =
            "Sorry you must enter an integer in the range -3 to 3, excluding zero.";
    public static final String RESET_USED = "Sorry you have used your reset.";
    public static final int MAX_LEGAL_HEAP_NUM = 3;
    public static final int MIN_LEGAL_HEAP_NUM = -MAX_LEGAL_HEAP_NUM;
    public static final String COINS_CHOICE_MSG = "Now choose a number of coins between 1 and %s: ";
    public static final String INTEGER_MSG = "Sorry you must enter an integer.";
    public static final String COINS_CHOICE_RE_ENTER_MSG = "Now choose between 1 and %s: ";
    public static final String ILLEGAL_COINS_MSG = "Sorry that's not a legal number of coins for that heap.";
    public static final String PLAYER_2_WINS_MSG = "Player 2 wins!";
    public static final String PLAYER_1_WINS_MSG = "Player 1 wins!";
    public static final String HEAP_RESET_MSG = "Heap %d has been reset%n";

    public static void main(String[] args) {
        int pile1 = PILE_SIZE;
        int pile2 = PILE_SIZE;
        int pile3 = PILE_SIZE;

        //The maximum coins that can be taken on a turn
        int pile1Max = PILE_MAX_INITIAL_REMOVAL;
        int pile2Max = PILE_MAX_INITIAL_REMOVAL;
        int pile3Max = PILE_MAX_INITIAL_REMOVAL;

        boolean finished = false;
        boolean isPlayer1 = true;

        boolean player1ResetUsed = false;
        boolean player2ResetUsed = false;

        Scanner in = new Scanner(System.in);

        //Continue playing as long as end condition - all heaps empty - not met
        while (!finished) {
            System.out.printf(REMAINING_COINS_MSG, pile1, pile2, pile3);
            int chosenPile = 0; //shut compiler up - otherwise it thinks it may not have been initialised
            boolean pileLegal = false;

            //Get a legal pile choice
            while (!pileLegal) {

                //Print message for the player currently playing
                if (isPlayer1) {
                    System.out.print(PLAYER_1_HEAP_CHOICE_MSG);
                } else {
                    System.out.print(PLAYER_2_HEAP_CHOICE_MSG);
                }

                //Get a legal integer
                while (!in.hasNextInt()) {
                    System.out.println(ILLEGAL_HEAP_RANGE);
                    in.nextLine();
                    if (isPlayer1) {
                        System.out.print(PLAYER_1_HEAP_CHOICE_MSG);
                    } else {
                        System.out.print(PLAYER_2_HEAP_CHOICE_MSG);
                    }
                }

                //Ensure that integer is in the legal range of heap choices
                chosenPile = in.nextInt();
                in.nextLine();
                pileLegal = chosenPile >= MIN_LEGAL_HEAP_NUM && chosenPile <= MAX_LEGAL_HEAP_NUM && chosenPile != 0
                        && (chosenPile == 1 && pile1 > 0
                        || chosenPile == 2 && pile2 > 0
                        || chosenPile == MAX_LEGAL_HEAP_NUM && pile3 > 0
                        || chosenPile < 0);
                if (!pileLegal) {
                    System.out.println(ILLEGAL_HEAP_CHOICE);
                }
            }

            //If negative the player is attempting to reset - check they haven't used their reset first
            if (chosenPile < 0
                    && (isPlayer1 && player1ResetUsed
                    || !isPlayer1 && player2ResetUsed)) {
                System.out.println(RESET_USED);

                //if they haven't used it, handle the reset
            } else if (chosenPile < 0) {

                //Set the appropriate player's reset to be used
                if (isPlayer1) {
                    player1ResetUsed = true;
                } else {
                    player2ResetUsed = true;
                }

                //handle the reset for the chosen pile
                System.out.printf(HEAP_RESET_MSG, -chosenPile);
                switch (chosenPile) {
                    case -1:
                        pile1 = PILE_SIZE;
                        pile1Max = PILE_MAX_INITIAL_REMOVAL;
                        break;
                    case -2:
                        pile2 = PILE_SIZE;
                        pile2Max = PILE_MAX_INITIAL_REMOVAL;
                        break;
                    case MIN_LEGAL_HEAP_NUM:
                        pile3 = PILE_SIZE;
                        pile3Max = PILE_MAX_INITIAL_REMOVAL;
                        break;
                    default:
                        break;
                }
                isPlayer1 = !isPlayer1; //skips the current player's turn

                // Otherwise, get a legal number of coins and update relevant heap
            } else if (!pileLegal) {
                System.out.println(ILLEGAL_HEAP_CHOICE);
            } else {
                int chosenCoins;
                boolean coinsLegal;

                //get a legal number of coins to take
                do {

                    //work out the max number of coins that can be taken
                    int maxLegalCoins = switch (chosenPile) {
                        case 1 -> Math.min(pile1, pile1Max);
                        case 2 -> Math.min(pile2, pile2Max);
                        case MAX_LEGAL_HEAP_NUM -> Math.min(pile3, pile3Max);
                        default -> 0;
                    };
                    System.out.printf(COINS_CHOICE_MSG, maxLegalCoins);

                    //get a legal integer
                    while (!in.hasNextInt()) {
                        System.out.println(INTEGER_MSG);
                        System.out.printf(COINS_CHOICE_RE_ENTER_MSG, maxLegalCoins);
                        in.nextLine();
                    }
                    chosenCoins = in.nextInt();
                    in.nextLine();

                    //check that integer is a legal coin choice
                    coinsLegal = chosenCoins > 0 && chosenCoins <= maxLegalCoins;
                    if (!coinsLegal) {
                        System.out.println(ILLEGAL_COINS_MSG);
                    }
                } while (!coinsLegal);

                //Update the relevant heap
                switch (chosenPile) {
                    case 1:
                        pile1 -= chosenCoins;
                        pile1Max = chosenCoins * 2;
                        break;
                    case 2:
                        pile2 -= chosenCoins;
                        pile2Max = chosenCoins * 2;
                        break;
                    case MAX_LEGAL_HEAP_NUM:
                        pile3 -= chosenCoins;
                        pile3Max = chosenCoins * 2;
                        break;
                    default:
                        break;
                }

                //switch players and check if the game is over
                isPlayer1 = !isPlayer1;
                finished = (pile1 + pile2 + pile3) == 0;
            }
        }

        //Winning message - remember we've 'swapped' players already
        if (isPlayer1) {
            System.out.println(PLAYER_2_WINS_MSG);
        } else {
            System.out.println(PLAYER_1_WINS_MSG);
        }
    }
}
