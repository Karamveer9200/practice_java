package CS_110.Assessment;

import java.util.Scanner;

public class FibonacciNim3 {
    static final int EMPTY = 0;

    // Coins in a full heap
    static final int FULL = 13;

    // Coins in each heap at the start
    static int HEAP_2 = FULL;
    static int HEAP_1 = FULL;
    static int HEAP_3 = FULL;

    // Current player's heap & coins
    static int chosenHeap;
    static int chosenCoins;

    // For reference
    static int chosenCoinsPreviousPlayerHeap1;
    static int chosenCoinsPreviousPlayerHeap2;
    static int chosenCoinsPreviousPlayerHeap3;
    static int chosenCoinsPreviousPlayer;

    // Total allowed resets
    static int playerA_Reset = 1;
    static int playerB_Reset = 1;

    // String messages
    static final  String MSG_REM_COINS = "Remaining coins: %d, %d, %d"; // HEAP_1, HEAP_2, HEAP_3
    static final  String MSG_HEAP_CHOOSE = "Player %c: choose a heap: ";
    static final  String MSG_H_NOT_INT = "Sorry you must enter an integer in the range -3 to 3, excluding zero.";
    static final String MSG_COIN_CHOOSE = "Now choose a number of coins between 1 and %d: ";
    static final String MSG_COIN_CHOOSE_2 = "Now choose between 1 and %d: ";
    static final  String MSG_C_NOT_INT = "Sorry you must enter an integer.";
    static final  String MSG_C_NOT_LEGAL = "Sorry that's not a legal number of coins for that heap.";

    public static void main(String[] args) {
        boolean allHeapsNot0 = true;
        char currentPlayer = '1';
        char winner = 'X';
        String returnValue;
        // passed Scanner 'in' through all the methods .: auto-grader throws exceptions if multiple scanner used
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

            // if all heaps are 0/empty, then currentPlayer = winner & change boolean to false
            if (HEAP_1 == EMPTY && HEAP_2 == EMPTY && HEAP_3 == EMPTY) {
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
        System.out.println("Player " + winner + " wins!");
    }   // THE MAIN METHOD ENDS HERE.

    // ALL METHODS used:
    // method to CHOOSE a HEAP
    static String heapSelection(char currentPlayer, Scanner in) {
        int currentHeap = 0;
        String returnValue = "no-reset";
        String resetResult;
        boolean notValid = true;

        System.out.println(String.format(MSG_REM_COINS, HEAP_1, HEAP_2, HEAP_3));
        do {
            System.out.print(String.format(MSG_HEAP_CHOOSE, currentPlayer));
            // check if input is an Integer
            while (!in.hasNextInt()) {
                System.out.println(MSG_H_NOT_INT);
                in.nextLine();
                System.out.print(String.format(MSG_HEAP_CHOOSE, currentPlayer));
            }
            // initialised variable chosenHeap
            // will be used in other methods, later on
            chosenHeap = in.nextInt();

            if (chosenHeap == 1 || chosenHeap == -1) {
                currentHeap = HEAP_1;
            } else if (chosenHeap == 2 || chosenHeap == -2) {
                currentHeap = HEAP_2;
            } else if (chosenHeap == 3 || chosenHeap == -3) {
                currentHeap = HEAP_3;
            }

            // checks if chosen heap is legal and is not empty
            if (chosenHeap >= 1 && chosenHeap <= 3 && currentHeap != EMPTY) {
                // will end the do-while loop
                notValid = false;
            }
            // conditions for a reset
            else if (chosenHeap <= -1 && chosenHeap >= -3) {
                //  function reset() called
                resetResult = reset(currentPlayer, chosenHeap);
                //  if reset is successful, do-while loop will end
                if (resetResult.equals("successful")) {
                    // if there is a reset, the return value of the method will be changed
                    returnValue = "reset";
                    // will end the do-while loop
                    notValid = false;
                }
                //  otherwise, scanner is cleared and loop continues
                else if (resetResult.equals("un-successful")) {
                    // Scanner cleaned for the next iteration
                    in.nextLine();
                }
            } else {
                // Scanner cleaned for the next iteration
                in.nextLine();
                System.out.println("Sorry that's not a legal heap choice.");
            }
        } while (notValid);
        // Method ends, Scanner cleaned
        in.nextLine();
        return returnValue;
    }

    // method to RESET chosen heap
    static String reset(char currentPlayer, int chosenHeap) {
        int heapNumber = 0;
        String result = "un-successful";
        // if statement only executes if current player has 1 reset
        if ((currentPlayer == '1' && playerA_Reset != EMPTY) || (currentPlayer == '2' && playerB_Reset != EMPTY)) {
            switch (chosenHeap) {
                // reset the chosen heap to FULL
                case -1:
                    HEAP_1 = FULL;
                    heapNumber = 1;
                    break;
                case -2:
                    HEAP_2 = FULL;
                    heapNumber = 2;
                    break;
                case -3:
                    HEAP_3 = FULL;
                    heapNumber = 3;
                    break;
            }
            System.out.println("Heap " + heapNumber + " has been reset");

            // changing the current player's reset from n to n-1
            if (currentPlayer == '1') {
                playerA_Reset -= 1;
            } else {
                playerB_Reset -= 1;
            }
            result = "successful";
        } else {
            System.out.println("Sorry you have used your reset.");
            System.out.println(String.format(MSG_REM_COINS, HEAP_1, HEAP_2, HEAP_3));
        }
        return result;
    }

    // method to TAKE COINS from the CHOSEN HEAP
    static void coinSelection(Scanner in) {
        boolean notValid = true;
        int currentHeap = 0;

        // to make chosen heap = current heap, and
        // to the select previous player's chosen coins, with respect to chosenHeap
        if (chosenHeap == 1) {
            currentHeap = HEAP_1;
            chosenCoinsPreviousPlayer = chosenCoinsPreviousPlayerHeap1;
        } else if (chosenHeap == 2) {
            currentHeap = HEAP_2;
            chosenCoinsPreviousPlayer = chosenCoinsPreviousPlayerHeap2;
        } else if (chosenHeap == 3) {
            currentHeap = HEAP_3;
            chosenCoinsPreviousPlayer = chosenCoinsPreviousPlayerHeap3;
        }
        do {
            // if chosen heap is FULL, then another method will be called
            if (currentHeap == FULL) {
                // calling another kinda similar method
                coinSelectionFullHeap(in);
                // will end the do-while loop
                notValid = false;
            } else { // if chosen heap is NOT FULL,
                // the current player can take 2X coins than what the previous player took,
                // if 2x(the previous player's coins) is within the current heap's range, then
                if ((2 * chosenCoinsPreviousPlayer) <= currentHeap) {
                    System.out.print(String.format(MSG_COIN_CHOOSE, 2 * chosenCoinsPreviousPlayer));
                    // check if input is an Integer
                    while (!in.hasNextInt()) {
                        System.out.println(MSG_C_NOT_INT);
                        in.nextLine();
                        System.out.print(String.format(MSG_COIN_CHOOSE_2, 2 * chosenCoinsPreviousPlayer));
                    }
                } else {
                    // if 2x(the previous player's coins) exceed current heap coins, then MAX current player can take
                    // is all the coins in the current heap
                    System.out.print(String.format(MSG_COIN_CHOOSE, currentHeap));
                    // check if input is an Integer
                    while (!in.hasNextInt()) {
                        System.out.println(MSG_C_NOT_INT);
                        in.nextLine();
                        System.out.print(String.format(MSG_COIN_CHOOSE_2, currentHeap));
                    }
                }
                chosenCoins = in.nextInt();
                // checks whether the chosenCoins are within the valid range
                if (chosenCoins > EMPTY && chosenCoins <= (2 * chosenCoinsPreviousPlayer) && chosenCoins <= currentHeap) {
                    // will end the do-while loop
                    notValid = false;
                    coinDeduction(chosenCoins);
                } else {
                    in.nextLine();
                    System.out.println(MSG_C_NOT_LEGAL);
                }
            }
        } while (notValid);
        // Method ends, Scanner cleaned
        in.nextLine();
    }

    // method to TAKE COINS from the CHOSEN HEAP (ONLY!! if the heap is 'FULL')
    static void coinSelectionFullHeap(Scanner in) {
        boolean notValid = true;

        do {
            // currentHeap - 1, because player cannot take all the coins from a FULL heap
            System.out.print(String.format(MSG_COIN_CHOOSE, FULL -1));

            // check if input is an Integer
            while (!in.hasNextInt()) {
                System.out.println(MSG_C_NOT_INT);
                in.nextLine();
                System.out.print(String.format(MSG_COIN_CHOOSE_2, FULL - 1));
            }
            chosenCoins = in.nextInt();
            // checks whether the chosenCoins are within the valid range (i.e. < 13)
            if (chosenCoins > EMPTY && chosenCoins < FULL) {
                // will end the do-while loop
                notValid = false;
                coinDeduction(chosenCoins);
            } else {
                // Scanner cleaned for the next iteration
                in.nextLine();
                System.out.println(MSG_C_NOT_LEGAL);
            }
        } while (notValid);
    }

    // method to deduct coins and to save player's coin choice for the current heap
    static void coinDeduction(int chosenCoins) {
        // chosenCoins will be deducted from the chosenHeap
        switch (chosenHeap) {
            case 1:
                HEAP_1 -= chosenCoins;
                // for reference (next player)
                chosenCoinsPreviousPlayerHeap1 = chosenCoins;
                break;
            case 2:
                HEAP_2 -= chosenCoins;
                chosenCoinsPreviousPlayerHeap2 = chosenCoins;
                break;
            case 3:
                HEAP_3 -= chosenCoins;
                chosenCoinsPreviousPlayerHeap3 = chosenCoins;
                break;
        }
    }
}