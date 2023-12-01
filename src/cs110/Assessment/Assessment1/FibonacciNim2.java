package cs110.Assessment.Assessment1;

import java.util.Scanner;

public class FibonacciNim2 {
    // Coins in a full heap
    static final int FULL = 13;

    // Coins in each heap at the start
    static int HEAP_2 = FULL;
    static int HEAP_1 = FULL;
    static int HEAP_3 = FULL;

    // Current player's heap & coins
    static int chosenHeap;
    static int chosenCoins;
    static int chosenCoinsPreviousPlayerHeap1;
    static int chosenCoinsPreviousPlayerHeap2;
    static int chosenCoinsPreviousPlayerHeap3;
    static int chosenCoinsPreviousPlayer;

    // Total allowed resets
    static int playerA_Reset = 1;
    static int playerB_Reset = 1;
    static int tries = 0;


    public static void main(String[] args) {
        boolean allHeapsNot0 = true;
        char currentPlayer = '1';
        char winner = 'N';
        String returnValue;
        // passed Scanner in all the methods .: auto-grader throws exceptions if multiple scanner used
        Scanner in = new Scanner(System.in);
        do {
            // method called to SELECT a HEAP (also to reset)
            returnValue = heapSelection(currentPlayer, in);
            // check for a reset

            // if there is a RESET!, the current player WON'T be prompted to take coins
            if (returnValue.equals("no-reset")) {
                // method to take coins from the selected heap, and do the computation ...
                coinSelection(in);
            }

            // check if all heaps are 0, if yes -> select the winner & change boolean to false
            if (HEAP_1 == 0 && HEAP_2 == 0 && HEAP_3 == 0) {
                winner = currentPlayer;
                // will end the do-while loop
                allHeapsNot0 = false;
            }

            // Player switching for the next iteration of the loop
            // A->B
            if (currentPlayer == '1') {
                currentPlayer = '2';
            } else {
                // B->A
                currentPlayer = '1';
            }
            tries += 1;
        } while (allHeapsNot0);
        // print the winner
        System.out.println("Player " + winner + " wins!");
    }   // MAIN METHOD ENDS HERE.

    // ALL METHODS used:
    // method to CHOOSE a HEAP
    static String heapSelection(char currentPlayer, Scanner in) {
        int currentHeap = 0;
        String returnValue = "no-reset";
        boolean notValid = true;
        boolean previousInput = true;


        System.out.println("Remaining coins: " + HEAP_1 + ", " + HEAP_2 + ", " + HEAP_3);
        do {
            System.out.print("Player " + currentPlayer + ": choose a heap: ");
            // check if input is an Integer
            while (!in.hasNextInt()) { //error here, skips user input after an invalid input proceeding a valid input
                System.out.println("Sorry you must enter an integer in the range -3 to 3, excluding zero.");
                in.nextLine();
                if (previousInput == true && tries !=0) { // if i don't use this condition here, while loop won't ask for input
                    in.nextLine();
                }
                System.out.print("Player " + currentPlayer + ": choose a heap: ");
                previousInput = false;

            }
            previousInput = true;
            // initialized variable chosenHeap
            // will be used in other methods, later on
            chosenHeap = in.nextInt();

            if (chosenHeap == 1 || chosenHeap == -1) {
                currentHeap = HEAP_1;
            } else if (chosenHeap == 2 || chosenHeap == -2) {
                currentHeap = HEAP_2;
            } else if (chosenHeap == 3 || chosenHeap == -3) {
                currentHeap = HEAP_3;
            }

            if (chosenHeap >= 1 && chosenHeap <= 3 && currentHeap !=0) {  // conditions for heap selection
                // check if chosen heap is empty or not

                // will end the do-while loop
                notValid = false;
            } else if (chosenHeap <= -1 && chosenHeap >= -3) { // conditions for a reset
                // && currentHeap != FULL, condition removed

                //  function reset() called inside of an if statement
                //  if statement only executes if the current player has 1 reset,
                //  otherwise the loop will jump to start, and ask to choose a heap again
                if (reset(currentPlayer, chosenHeap).equals("successful")) {
                    // will end the do-while loop
                    notValid = false;
                    // when there is a reset return value of the method will be changed
                    returnValue = "reset";
                }
            } else {
                System.out.println("Sorry that's not a legal heap choice.");
            }
        } while (notValid);
        return returnValue;
    }

    // method to RESET chosen heap
    static String reset(char currentPlayer, int chosenHeap) {
        int heap = 0;
        String result = "un-successful";
        // if statement only executes if current player has 1 reset
        if ((currentPlayer == '1' && playerA_Reset == 1) || (currentPlayer == '2' && playerB_Reset == 1)) {
            switch (chosenHeap) {
                // reset the chosen heap to FULL
                case -1:
                    HEAP_1 = FULL;
                    heap = 1;
                    break;
                case -2:
                    HEAP_2 = FULL;
                    heap = 2;
                    break;
                case -3:
                    HEAP_3 = FULL;
                    heap = 3;
                    break;
            }
            System.out.println("Heap "+ heap +" has been reset");
            // changing the current player's reset from 1 to 0
            if (currentPlayer == '1') {
                playerA_Reset = 0;
            } else {
                playerB_Reset = 0;
            }
            result = "successful";
        } else {
            System.out.println("Sorry you have used your reset.");
            System.out.println("Remaining coins: " + HEAP_1 + ", " + HEAP_2 + ", " + HEAP_3);
        }
        return result;
    }

    // method to TAKE COINS from the CHOSEN HEAP
    static void coinSelection(Scanner in) {
        boolean notValid = true;
        boolean previousInput = true;
        int currentHeap = 0;

        // logic to make chosen heap = current heap
        // logic to choose the precious player's chosen heap coins
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
            // if chosen heap is FULL/NEW, then another method will be called
            if (currentHeap == FULL) {
                // calling another kinda similar method
                coinSelectionFullHeap(in);
                // will end the do-while loop
                notValid = false;
            } else {
                // the current player is allowed 2x the number of coins
                // if 2x(the previous player's coins) is within the current heap's range, then
                if ((2 * chosenCoinsPreviousPlayer) <= currentHeap) {
                    System.out.print("Now choose a number of coins between 1 and " + (2 * chosenCoinsPreviousPlayer) + ": ");
                    // check if input is an Integer
                    while (!in.hasNextInt()) {
                        System.out.println("Sorry you must enter an integer.");
                        in.nextLine();
                        if (previousInput == true) {
                            in.nextLine();
                        }
                        System.out.print("Now choose between 1 and " + (2 * chosenCoinsPreviousPlayer) + ": ");
                        previousInput = false;
                    }
                } else {
                    // if 2x(the previous player's coins) exceed current heap coins, then MAX current player can take
                    // is all the coins in the current heap
                    System.out.print("Now choose a number of coins between 1 and " + currentHeap + ": ");
                    // check if input is an Integer
                    while (!in.hasNextInt()) {
                        System.out.println("Sorry you must enter an integer.");
                        in.nextLine();
                        if (previousInput == true) {
                            in.nextLine();
                        }
                        System.out.print("Now choose between 1 and " + currentHeap + ": ");
                        previousInput = false;
                    }
                }

                previousInput = true;
                chosenCoins = in.nextInt();

                // the current player can take 2X coins than what the previous player took,
                // BUT! it should not exceed the current heap's MAX limit
                if (chosenCoins > 0 && chosenCoins <= (2 * chosenCoinsPreviousPlayer) && chosenCoins <= currentHeap) {
                    // will end the do-while loop
                    notValid = false;

                    // chosenCoins will be deducted from the chosenHeap
                    switch (chosenHeap) {
                        case 1:
                            HEAP_1 -= chosenCoins;
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
                } else {
                    System.out.println("Sorry that's not a legal number of coins for that heap.");
                }
            }
        } while (notValid);
    }

    // method to TAKE COINS from the CHOSEN HEAP (ONLY!! if the heap is 'FULL')
    static void coinSelectionFullHeap(Scanner in) {
        boolean notValid = true;
        boolean previousInput = true;

        do {
            // currentHeap - 1, because player cannot take all the coins from a FULL/NEW heap
            System.out.print("Now choose a number of coins between 1 and " + (FULL - 1) + ": ");

            // check if input is an Integer
            while (!in.hasNextInt()) {
                System.out.println("Sorry you must enter an integer.");
                in.nextLine();
                if (previousInput == true) { // if i don't use this condition here, while loop won't ask for input
                    in.nextLine();
                }
                System.out.print("Now choose between 1 and " + (FULL - 1) + ": ");
                previousInput = false;
            }
            previousInput = true;
            // initialized variable coinSelect
            chosenCoins = in.nextInt();

            // if the current player chooses to take a valid number of coins (i.e. < 13)
            if (chosenCoins > 0 && chosenCoins < FULL) {
                // will end the do-while loop
                notValid = false;

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
            } else {
                System.out.println("Sorry that's not a legal number of coins for that heap.");
            }
        } while (notValid);
    }
}
