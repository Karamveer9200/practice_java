package CS_110.Assessment;

import java.util.Scanner;

public class FibonacciNim {
    // Coins in a full heap
    static final int FULL = 13;

    // Coins in each heap at the start
    static int HEAP_2 = FULL;
    static int HEAP_1 = FULL;
    static int HEAP_3 = FULL;

    // Current player's heap & coins
    static int chosenHeap;
    static int chosenCoins;
    static int chosenCoinsPreviousPlayer;

    // Total allowed resets
    static int playerA_Reset = 1;
    static int playerB_Reset = 1;


    public static void main(String[] args) {
        boolean allHeapsNot0 = true;
        char currentPlayer = 'A';
        char winner = 'N';
        String returnValue;
        do {
            // method called to SELECT a HEAP (also to reset)
            returnValue = heapSelection(currentPlayer);
            // check for a reset

            // if there is a RESET!, the current player WON'T be prompted to take coins
            if (returnValue.equals("no-reset")) {
                // method to take coins from the selected heap, and do the computation ...
                coinSelection();
            }

            // check if all heaps are 0, if yes -> select the winner & change boolean to false
            if (HEAP_1 == 0 && HEAP_2 == 0 && HEAP_3 == 0) {
                winner = currentPlayer;
                // will end the do-while loop
                allHeapsNot0 = false;
            }

            // Player switching for the next iteration of the loop
            // A->B
            if (currentPlayer == 'A') {
                currentPlayer = 'B';
            } else {
                // B->A
                currentPlayer = 'A';
            }
        } while (allHeapsNot0);
        // print the winner
        System.out.println("Player " + winner + " wins!");
    }   // THIS PROGRAM ENDS HERE.

    // ALL METHODS used:
    // method to CHOOSE a HEAP
    static String heapSelection(char player) {
        String returnValue = "no-reset";
        boolean notValid = true;
        do {
            System.out.println("Remaining coins : " + HEAP_1 + "," + HEAP_2 + "," + HEAP_3);
            System.out.print("Player " + player + ": choose a heap : ");

            Scanner sc = new Scanner(System.in);
            // check if input is an Integer
            while (!sc.hasNextInt()) {
                System.out.println("Sorry you must enter an integer in the range -3 to 3, excluding zero.");
                sc.nextLine();
            }
            // initialized variable chosenHeap
            // will be used in other methods, later on
            chosenHeap = sc.nextInt();
            if (chosenHeap >= 1 && chosenHeap <= 3) {  // conditions for heap selection
                // check if chosen heap is empty or not

                // will end the do-while loop
                notValid = false;
            } else if (chosenHeap <= -1 && chosenHeap >= -3) { // conditions for a reset
                //  function reset() called inside of an if statement
                //  if statement only executes if the current player has 1 reset,
                //  otherwise the loop will jump to start, and ask to choose a heap again
                if (reset(player, chosenHeap).equals("successful")) {
                    // will end the do-while loop
                    notValid = false;
                    // when there is a reset return value of the method will be changed
                    returnValue = "reset";
                }

            } else {
                System.out.println("Sorry you must enter an integer in the range -3 to 3, excluding zero.");
            }
        } while (notValid);
        return returnValue;
    }

    // method to RESET chosen heap
    static String reset(char player, int chosenHeap) {
        String result = "un-successful";
        // if statement only executes if current player has 1 reset
        if ((player == 'A' && playerA_Reset == 1) || (player == 'B' && playerB_Reset == 1)) {
            switch (chosenHeap) {
                // reset the chosen heap to FULL
                case -1:
                    HEAP_1 = FULL;
                    break;
                case -2:
                    HEAP_2 = FULL;
                    break;
                case -3:
                    HEAP_3 = FULL;
                    break;
            }
            // changing the current player's reset from 1 to 0
            if (player == 'A') {
                playerA_Reset = 0;
            } else {
                playerB_Reset = 0;
            }
            result = "successful";
        } else {
            System.out.println("Sorry you have used your reset.");
        }
        return result;
    }

    // method to TAKE COINS from the CHOSEN HEAP
    static void coinSelection() {
        boolean notValid = true;
        int currentHeap = 0;

        // logic to make chosen heap = current heap
        if (chosenHeap == 1) {
            currentHeap = HEAP_1;
        } else if (chosenHeap == 2) {
            currentHeap = HEAP_2;
        } else if (chosenHeap == 3) {
            currentHeap = HEAP_3;
        }
        do {
            // if chosen heap is FULL/NEW, then another method will be called
            if (currentHeap == FULL) {
                // calling another kinda similar method
                coinSelectionFullHeap();
                // will end the do-while loop
                notValid = false;
            } else {
                // the current player is allowed 2x the number of coins
                // if 2x(the previous player's coins) is within the current heap's range, then
                if ((2 * chosenCoinsPreviousPlayer) <= currentHeap) {
                    System.out.print("Now choose a number of coins between 1 and " + (2 * chosenCoinsPreviousPlayer) + ": ");
                } else {
                    // if 2x(the previous player's coins) exceed current heap coins, then MAX current player can take
                    // is all the coins in the current heap
                    System.out.print("Now choose a number of coins between 1 and " + currentHeap + ": ");
                }
                chosenCoins = getInt();

                // the current player can take 2X coins than what the previous player took,
                // BUT! it should not exceed the current heap's MAX limit
                if (chosenCoins <= (2 * chosenCoinsPreviousPlayer) && chosenCoins <= currentHeap) { // More conditions here
                    // will end the do-while loop
                    notValid = false;

                    // for reference (next player)
                    chosenCoinsPreviousPlayer = chosenCoins;

                    // chosenCoins will be deducted from the chosenHeap
                    switch (chosenHeap) {
                        case 1:
                            HEAP_1 -= chosenCoins;
                            break;
                        case 2:
                            HEAP_2 -= chosenCoins;
                            break;
                        case 3:
                            HEAP_3 -= chosenCoins;
                            break;
                    }
                } else {
                    System.out.println("Sorry that's not a legal number of coins for that heap.");
                }
            }
        } while (notValid);
    }

    // method to TAKE COINS from the CHOSEN HEAP (ONLY!! if the heap is 'FULL')
    static void coinSelectionFullHeap() {
        boolean notValid = true;

        do {
            // currentHeap - 1, because player cannot take all the coins from a FULL/NEW heap
            System.out.print("Now choose a number of coins between 1 and " + (FULL - 1) + ": ");

            // initialized variable coinSelect
            chosenCoins = getInt();

            // for reference (next player)
            chosenCoinsPreviousPlayer = chosenCoins;

            // if the current player chooses to take a valid number of coins (i.e. < 13)
            if (chosenCoins < FULL) {
                // will end the do-while loop
                notValid = false;

                // chosenCoins will be deducted from the chosenHeap
                switch (chosenHeap) {
                    case 1:
                        HEAP_1 -= chosenCoins;
                        break;
                    case 2:
                        HEAP_2 -= chosenCoins;
                        break;
                    case 3:
                        HEAP_3 -= chosenCoins;
                        break;
                }
            } else {
                System.out.println("Sorry that's not a legal number of coins for that heap.");
            }
        } while (notValid);
    }
    static int getInt() {
        int returnValue;
        Scanner in = new Scanner(System.in);
        // check if input is an Integer
        while (!in.hasNextInt()) {
            System.out.println("Sorry you must enter an integer.");
            in.nextLine();
        }
        returnValue = in.nextInt();
        return returnValue;
    }
}



