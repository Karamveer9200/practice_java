package cs.Assessment;

import java.util.Scanner;
import java.util.Arrays;

public class FibonacciNim {
    // Coins in an empty heap
    static final int EMPTY = 0;
    // Coins in a full heap
    static final int FULL = 13;

    // Coins in each heap at the start
    private static int[] heap = {FULL, FULL, FULL};

    // Current player's heap & coins
    private static final int[] LEGAL_HEAP_CHOICE = {1, 2, 3};
    private static final int[] LEGAL_HEAP_CHOICE_RESET = {-3, -2, -1};
    private static int chosenHeap;
    private static int chosenCoins;

    // For reference; previous player's coin choice
    private static int[] chosenCoinsPreviousPlayerHeap = {0, 0, 0};
    private static int chosenCoinsPreviousPlayer;

    // Total allowed resets
    private static int player1Reset = 1;
    private static int player2Reset = 1;

    // String messages:
    // heap messages
    static final String MSG_REM_COINS = "Remaining coins: %d, %d, %d";
    static final String MSG_CHOOSE_HEAP = "Player %c: choose a heap: ";
    static final String MSG_H_NOT_INT = "Sorry you must enter an integer in the range -3 to 3, excluding zero.";
    static final String MSG_H_NOT_LEGAL = "Sorry that's not a legal heap choice.";
    // coin messages
    static final String MSG_CHOOSE_COINS = "Now choose a number of coins between 1 and %d: ";
    static final String MSG_CHOOSE_COINS_AGAIN = "Now choose between 1 and %d: ";
    static final String MSG_C_NOT_INT = "Sorry you must enter an integer.";
    static final String MSG_C_NOT_LEGAL = "Sorry that's not a legal number of coins for that heap.";
    // reset messages
    static final String MSG_H_RESET_SUCCESS = "Heap %d has been reset";
    static final String MSG_H_RESET_FAIL = "Sorry you have used your reset.";

    // winner message
    static final String MSG_WINNER = "Player %c wins!";


    public static void main(String[] args) {
        boolean allHeapsNot0 = true;
        char currentPlayer = '1';
        char winner = 'X';
        String returnValue;
        // passed Scanner 'in' through all the methods .: auto-grader throws exceptions if multiple scanners used
        Scanner in = new Scanner(System.in);
        do {
            // method called to SELECT/RESET a HEAP
            returnValue = heapSelection(currentPlayer, in);

            // check for a reset
            // if there is a RESET!, the current player WON'T be prompted to take coins
            if (returnValue.equals("no-reset")) {
                // method to take coins from the selected heap, and do the computation ...
                coinSelection(in);
            }

            // if all heaps are 0/EMPTY, then currentPlayer = winner & change boolean to false
            if (heap[0] == EMPTY && heap[1] == EMPTY && heap[2] == EMPTY) {
                winner = currentPlayer;
                // will end the do-while loop
                allHeapsNot0 = false;
            }

            // Player switching for the next iteration of the loop
            if (currentPlayer == '1') {
                // 1 -> 2
                currentPlayer = '2';
            } else {
                // 2 -> 1
                currentPlayer = '1';
            }
        } while (allHeapsNot0);
        // prints the winner
        System.out.println(String.format(MSG_WINNER, winner));
    }   // THE MAIN METHOD ENDS HERE.

    // ALL METHODS used:
    // method to CHOOSE a HEAP
    static String heapSelection(char currentPlayer, Scanner in) {
        int currentHeap = 0;
        String returnValue = "no-reset";
        String resetResult;
        boolean notValid = true;

        System.out.println(String.format(MSG_REM_COINS, heap[0], heap[1], heap[2]));
        do {
            System.out.print(String.format(MSG_CHOOSE_HEAP, currentPlayer));
            // check if input is an Integer
            while (!in.hasNextInt()) {
                System.out.println(MSG_H_NOT_INT);
                in.nextLine();
                System.out.print(String.format(MSG_CHOOSE_HEAP, currentPlayer));
            }
            // initialised variable chosenHeap
            // will be used in other methods, later on
            chosenHeap = in.nextInt();

            // choosing the current heap
            // Note: I was using if-else statements earlier
            // To avoid magic numbers, I am using a for-loop
            int j = LEGAL_HEAP_CHOICE.length - 1;
            for (int i = 0; i < LEGAL_HEAP_CHOICE.length; i++) {
                // suppose when i = 0, j = LEGAL_HEAP_CHOICE.length - 1
                // LEGAL_HEAP_CHOICE[0] = 1, LEGAL_HEAP_CHOICE_RESET[0 + 2] = -1
                if (chosenHeap == LEGAL_HEAP_CHOICE[i] || chosenHeap == LEGAL_HEAP_CHOICE_RESET[i + j]) {
                    currentHeap = heap[i];
                }
                j--;
            }

            // checks if chosen heap is 'legal' and is 'not' empty
            // Arrays.binarySearch(LEGAL_HEAP_CHOICE, chosenHeap) will return an index number, only if
            // the element (that we are searching) is present in the array
            if (Arrays.binarySearch(LEGAL_HEAP_CHOICE, chosenHeap) >= 0 && currentHeap != EMPTY) {
                // will end the do-while loop
                notValid = false;
            } else if (Arrays.binarySearch(LEGAL_HEAP_CHOICE_RESET, chosenHeap) >= 0) {
                // above is the condition for a 'reset'

                // 'converting' chosenHeap -ve to +ve
                chosenHeap -= 2 * chosenHeap;
                //  method reset() called
                resetResult = reset(currentPlayer, chosenHeap);
                //  if reset is successful, do-while loop will end
                if (resetResult.equals("successful")) {
                    // if there is a reset, the 'return value' of the method 'heapSelection' will be changed
                    returnValue = "reset";
                    // will end the do-while loop
                    notValid = false;
                } else if (resetResult.equals("un-successful")) {
                    // Current Input cleaned, loop continues (to ask currentPlayer to choose a heap again)
                    in.nextLine();
                }
            } else {
                // Current Input cleaned, loop continues
                in.nextLine();
                System.out.println(MSG_H_NOT_LEGAL);
            }
        } while (notValid);
        // Method ends, Input cleaned
        in.nextLine();
        return returnValue;
    }

    // method to RESET chosen heap
    static String reset(char currentPlayer, int chosenHeap) {
        int heapNumber = 0;
        String result = "un-successful";
        // if statement only executes if current player has 1 reset
        if ((currentPlayer == '1' && player1Reset != EMPTY) || (currentPlayer == '2' && player2Reset != EMPTY)) {

            // reset the chosen heap to FULL
            for (int i = 0; i < LEGAL_HEAP_CHOICE.length; i++) {
                if (chosenHeap == LEGAL_HEAP_CHOICE[i]) {
                    heap[i] = FULL;
                    heapNumber = LEGAL_HEAP_CHOICE[i];
                }
            }
            System.out.println(String.format(MSG_H_RESET_SUCCESS, heapNumber));

            // changing the current player's reset from n to n-1
            if (currentPlayer == '1') {
                player1Reset -= 1;
            } else {
                player2Reset -= 1;
            }

            result = "successful";
        } else {
            System.out.println(MSG_H_RESET_FAIL);
            System.out.println(String.format(MSG_REM_COINS, heap[0], heap[1], heap[2]));
        }
        return result;
    }


    // method to TAKE COINS from the CHOSEN HEAP
    static void coinSelection(Scanner in) {
        int currentHeap = 0;

        // to make chosen heap = current heap, and
        // to the select previous player's chosen coins, with respect to chosenHeap
        for (int i = 0; i < LEGAL_HEAP_CHOICE.length; i++) {
            if (chosenHeap == LEGAL_HEAP_CHOICE[i]) {
                currentHeap = heap[i];
                chosenCoinsPreviousPlayer = chosenCoinsPreviousPlayerHeap[i];
            }
        }

        // if chosen heap is FULL/NOT FULL, then another method will be called
        if (currentHeap == FULL) {
            // method to select coins (FULL heap)
            coinSelectionFullHeap(in);
        } else {
            // method to select coins (NOT-FULL heap)
            coinSelectionNotFullHeap(in, currentHeap);
        }
        // Method ends, Input cleaned
        in.nextLine();
    }

    // method to TAKE COINS from the CHOSEN HEAP (ONLY!! if the heap is 'FULL')
    static void coinSelectionFullHeap(Scanner in) {
        boolean notValid = true;

        do {
            // currentHeap - 1, because player cannot take all the coins from a FULL heap
            System.out.print(String.format(MSG_CHOOSE_COINS, FULL - 1));

            // check if input is an Integer
            while (!in.hasNextInt()) {
                System.out.println(MSG_C_NOT_INT);
                in.nextLine();
                System.out.print(String.format(MSG_CHOOSE_COINS_AGAIN, FULL - 1));
            }
            chosenCoins = in.nextInt();
            // checks whether the chosenCoins are within the valid range (i.e. < 13)
            if (chosenCoins > EMPTY && chosenCoins < FULL) {
                // will end the do-while loop
                notValid = false;
                coinDeduction(chosenCoins);
            } else {
                // Current Input cleaned, loop continues
                in.nextLine();
                System.out.println(MSG_C_NOT_LEGAL);
            }
        } while (notValid);
    }

    static void coinSelectionNotFullHeap(Scanner in, int currentHeap) {
        boolean notValid = true;

        do {
            // if chosen heap is NOT FULL,
            // the currentPlayer can take 2X coins than what the previous player took,
            // if 2x(the previous player's coins) is within the current heap's range, then
            if ((2 * chosenCoinsPreviousPlayer) <= currentHeap) {
                System.out.print(String.format(MSG_CHOOSE_COINS, 2 * chosenCoinsPreviousPlayer));
                // check if input is an Integer
                while (!in.hasNextInt()) {
                    System.out.println(MSG_C_NOT_INT);
                    in.nextLine();
                    System.out.print(String.format(MSG_CHOOSE_COINS_AGAIN, 2 * chosenCoinsPreviousPlayer));
                }
            } else {
                // if 2x(the previous player's coins) exceed currentHeap coins,
                // then MAX current currentPlayer can take is all the coins in the currentHeap
                System.out.print(String.format(MSG_CHOOSE_COINS, currentHeap));
                // check if input is an Integer
                while (!in.hasNextInt()) {
                    System.out.println(MSG_C_NOT_INT);
                    in.nextLine();
                    System.out.print(String.format(MSG_CHOOSE_COINS_AGAIN, currentHeap));
                }
            }
            chosenCoins = in.nextInt();
            // checks whether the chosenCoins are within the valid range
            if (chosenCoins > EMPTY && chosenCoins <= (2 * chosenCoinsPreviousPlayer)
                    && chosenCoins <= currentHeap) {
                // will end the do-while loop
                notValid = false;
                coinDeduction(chosenCoins);
            } else {
                // Current Input cleaned, loop continues (to ask currentPlayer to choose coins again)
                in.nextLine();
                System.out.println(MSG_C_NOT_LEGAL);
            }
        } while (notValid);
    }

    // method to deduct coins and to save player's coin choice for the current heap
    static void coinDeduction(int chosenCoins) {
        // chosenCoins will be deducted from the chosenHeap
        for (int i = 0; i < LEGAL_HEAP_CHOICE.length; i++) {
            if (chosenHeap == LEGAL_HEAP_CHOICE[i]) {
                heap[i] -= chosenCoins;
                chosenCoinsPreviousPlayerHeap[i] = chosenCoins;
            }
        }
    }
}