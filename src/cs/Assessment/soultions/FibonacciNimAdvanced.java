
import java.util.Arrays;
import java.util.Scanner;

/**
Java program to play the game Fibonacci Nim to Level 4 - this version would get the exceptional marks by using advanced
(Javadoc) commenting and also using arrays in a way that makes it trivial to change the number of heaps (by just
changing a constant). Using arrays avoids switch statements and so shortens the code but (IMHO at least) the
extra complexity in understanding that comes with this isn't worth it unless you use the ability to easily change
the number of heaps (by extension, you could do the same thing with the number of players.

 Additionally, this version breaks the work down into a number of methods - which some solutions also did. IMHO the
 main method is still a bit too big.
 */
public class FibonacciNimAdvanced {

    //Constants allow us to change heap sizes, number of heaps and messages without reading the code
    public static final int PILE_SIZE = 13;

    public static final int NUM_HEAPS = 3;
    //Only change if you want to allow a different initial coin choice
    public static final int PILE_MAX_INITIAL_REMOVAL = PILE_SIZE - 1;

    public static final String ITEM_SEPARATOR = ", ";
    public static final String PLAYER_HEAP_CHOICE_MSG = "Player %d: choose a heap: ";
    public static final String REMAINING_COINS_MSG = "Remaining coins: ";
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

    /**
     * <p>"Standard" non-OO representation of the game of Fibonacci Nim</p>
     * <ol>
     *     <li>A game for two players</li>
     *     <li>Players take it in turns to take coins from one of a number of heaps (by default,
     *     3 with 13 coins each</li>
     *     <li>For the first turn, the default maximum number of coins that can be taken is 12</li>
     *     <li>After that, the maximum number that can be taken is twice the number taken <em>from that
     *     particular heap</em> on the turn before (if less than the number remaining in the pile</li>
     *     <li>Players have <em>one</em> opportunity to 'reset' to the default starting value <em>one</em>
     *     of the heaps (by typing a negative number representing it's - e.g. to reset heap 1, enter -1 - doing so
     *     also skips the current player's turn</li>
     *     <li>The winner is the player who take the final coin(s)</li>
     * </ol>
     * @param args command line arguments, unused in this case
     */
    public static void main(String[] args) {

        //Create and fill arrays for heaps and the max number of coins that can be taken from them
        int[] heaps = new int[NUM_HEAPS];
        int[] heapRemoveLimits = new int[NUM_HEAPS];
        Arrays.fill(heaps, PILE_SIZE);
        Arrays.fill(heapRemoveLimits, PILE_MAX_INITIAL_REMOVAL);

        boolean finished = false;
        boolean isPlayer1 = true;

        boolean player1ResetUsed = false;
        boolean player2ResetUsed = false;

        Scanner in = new Scanner(System.in);

        //Continue playing as long as end condition - all heaps empty - not met
        while (!finished) {
            System.out.println(generateRemainingCoinsMsg(heaps));
             boolean pileLegal = false;

            //Get a legal pile and coin choice
            do {

                //Get a legal pile choice
                int chosenHeap = getLegalHeapChoice(in, isPlayer1 ? 1 : 2);

                //If negative the player is attempting to reset - check they haven't used their reset first
                if (chosenHeap < 0
                        && (isPlayer1 && player1ResetUsed
                        || !isPlayer1 && player2ResetUsed)) {
                    System.out.println(RESET_USED);
                    System.out.println(generateRemainingCoinsMsg(heaps));

                //if they haven't used it, handle the reset
                } else if (chosenHeap < 0) {

                    //Set the appropriate player's reset to be used
                    if (isPlayer1) {
                        player1ResetUsed = true;
                    } else {
                        player2ResetUsed = true;
                    }

                    //handle the reset for the chosen pile
                    heaps[-chosenHeap - 1] = PILE_SIZE;
                    heapRemoveLimits[-chosenHeap - 1] = PILE_MAX_INITIAL_REMOVAL;
                    isPlayer1 = !isPlayer1; //skips the current player's turn
                    System.out.printf(HEAP_RESET_MSG, -chosenHeap);
                    System.out.println(generateRemainingCoinsMsg(heaps));

                // Otherwise, get a legal number of coins and update relevant heap
                } else {

                    //chosen pile cannot be empty
                    pileLegal = heaps[chosenHeap - 1] > 0;
                    if (!pileLegal) {
                        System.out.println(ILLEGAL_HEAP_CHOICE);
                    } else {
                        int chosenCoins;
                        boolean coinsLegal;

                        //get a legal number of coins to take
                        chosenCoins = getChosenCoins(in, Math.min(heaps[chosenHeap - 1],
                                heapRemoveLimits[chosenHeap - 1]));

                        //Update the relevant heap
                        heaps[chosenHeap - 1] -= chosenCoins;
                        heapRemoveLimits[chosenHeap - 1] = chosenCoins * 2;

                        //switch players and check if the game is over
                        isPlayer1 = !isPlayer1;
                        finished = pilesEmpty(heaps);
                    }
                }
            } while (!pileLegal);
        }

        //Winning message - remember we've 'swapped' players already
        if (isPlayer1) {
            System.out.println(PLAYER_2_WINS_MSG);
        } else {
            System.out.println(PLAYER_1_WINS_MSG);
        }
    }

    /**
     * Get a legal number of coins to remove from a heap - prompts the user and re-asks until a legal value is
     * provided
     * @param in Scanner to read input
     * @param maxRemove the maximum number of coins that can be chosen
     * @return
     */
    private static int getChosenCoins(final Scanner in, final int maxRemove) {
        int chosenCoins;
        boolean coinsLegal;
        do {

            //work out the max number of coins that can be taken
             System.out.printf(COINS_CHOICE_MSG, maxRemove);

            //get a legal integer that is a legal number of coins to choose
            chosenCoins = getIntVal(in, INTEGER_MSG, COINS_CHOICE_RE_ENTER_MSG, maxRemove);
            coinsLegal = chosenCoins > 0 && chosenCoins <= maxRemove;
            if (!coinsLegal) {
                System.out.println(ILLEGAL_COINS_MSG);
            }
        } while (!coinsLegal);
        return chosenCoins;
    }

    /**
     * Get a potentially legal heap - this means a heap within the allowable range but does <em>not</em> at this
     * point exclude heaps that are empty. Prompts the user and repeatedly asks for a legal heap choice until one
     * is entered.
     * @param in Scanner to read input
     * @param player current player - needed to configure the messaing to the player
     * @return
     */
    public static int getLegalHeapChoice(final Scanner in, final  int player) {
        int chosenHeap = 0; //shut compiler up - otherwise it thinks it may not have been initialised
        boolean pileLegal = false;

        while (!pileLegal) {

            //Print message for the player currently playing
            System.out.printf(PLAYER_HEAP_CHOICE_MSG, player);

            //Get integer in the legal range of heap choices
            chosenHeap = getIntVal(in, ILLEGAL_HEAP_RANGE, PLAYER_HEAP_CHOICE_MSG, player);
            pileLegal = chosenHeap >= MIN_LEGAL_HEAP_NUM && chosenHeap <= MAX_LEGAL_HEAP_NUM && chosenHeap != 0;
            if (!pileLegal) {
                System.out.println(ILLEGAL_HEAP_CHOICE);
            }
        }
        return chosenHeap;
    }

    /**
     * Method to get an integer value based on a pair of prompts to message the user, the second of which includes
     * a user-settable integer parameter. Restrictions on testing via Autograder require that we pass the Scanner as a
     * parameter (normally we probably would create the scanner in the method).
     * @param in Scanner used to read input
     * @param prompt First output prompt - a simple text String
     * @param secondaryPrompt Second output prompt <em>must</em> contain a %d for use as a formatted string
     * @param limitVal Appears embedded in the secondaryPrompt output
     * @return
     */
    public static int getIntVal(final Scanner in, final String prompt,
                                final String secondaryPrompt, final int limitVal) {
        while (!in.hasNextInt()) {
            System.out.println(prompt);
            System.out.printf(secondaryPrompt, limitVal);
            in.nextLine();
        }
        final int returnVal = in.nextInt();
        in.nextLine();
        return returnVal;
    }

    /**
     * Generate an appropriately formatted string representing the remaining coins in all piles, regardless of how
     * many there are.
     * @param piles the array of piles
     * @return formatted readable string representing the number of remaining coins in each pile
     */
    public static String generateRemainingCoinsMsg(final int[] piles) {
        StringBuilder outString = new StringBuilder(REMAINING_COINS_MSG);
        String sep = "";
        for (int pile : piles) {
            outString.append(sep).append(pile);
            sep = ITEM_SEPARATOR; //slightly yukky...
        }
        return outString.toString();
    }

    /**
     * Check if all piles are empty
     * @param piles the array of piles
     * @return true if all are empty; false otherwise
     */
    public static boolean pilesEmpty(final int[] piles) {
        int sumPiles = 0;
        for (int pile: piles) {
            sumPiles += pile;
        }
        return sumPiles == 0;
    }
}
