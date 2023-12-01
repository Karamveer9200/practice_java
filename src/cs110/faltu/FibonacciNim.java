package cs110.faltu;

import java.util.Scanner;

public class FibonacciNim {

    // Maximum coins in a heap.
    private static final int FULL_HEAP = 13;
    // Coins in each heap at the beginning.
    private static int heaps1 = FULL_HEAP;
    private static int heaps2 = FULL_HEAP;
    private static int heaps3 = FULL_HEAP;
    // Maximum Number of legal heap.
    private static final int MAX_LEGAL_HEAP = 3;


    public static void main(String[] args) {
        int player = 1;
        int selectionOfHeaps;
        int chosenCoins = 0;
        int workingHeap = 0;
        boolean heapsNot0 = true;
        int winner = 0;
        int choiceTrackerHeap1 = 0;
        int choiceTrackerHeap2 = 0;
        int choiceTrackerHeap3 = 0;
        int choiceTracker = 0;
        Scanner playerInput = new Scanner(System.in);

        // Heap selection logic.
        do {
            System.out.println("Remaining coins: " + heaps1 + ", " + heaps2 + ", " + heaps3);
            System.out.print("Player "+ player +": choose a heap: ");
            // validity check.
            while (!playerInput.hasNextInt())  {
                playerInput.nextLine();
                System.out.println("Sorry you must enter an integer in the range -3 to 3, excluding zero.");
                System.out.print("Player "+ player +": choose a heap: ");
            }
            // When valid, input assigned to selectionOfHeaps.
            selectionOfHeaps = playerInput.nextInt();

            if (selectionOfHeaps == 1) {
                workingHeap = heaps1;
            } else if (selectionOfHeaps == 2) {
                workingHeap = heaps2;
            } else if (selectionOfHeaps == MAX_LEGAL_HEAP) {
                workingHeap = heaps3;
            } else {
                System.out.println("Invalid Input");
            }
            // Player input for coins after selection of heap.
            playerInput.nextLine();
            if (workingHeap == FULL_HEAP) {
                System.out.print("Now choose a number of coins between 1 and " + (workingHeap - 1)+": ");
                // validity check.
                while (!playerInput.hasNextInt()){
                    playerInput.nextLine();
                    System.out.println("Sorry you must enter an integer.");
                    System.out.print("Now choose between 1 and " + (workingHeap - 1) + ": ");
                }
                // When valid, input assigned to chosenCoins.
                chosenCoins =playerInput.nextInt();
            } else {
                if (selectionOfHeaps == 1) {
                    choiceTracker = choiceTrackerHeap1;
                } else if (selectionOfHeaps == 2) {
                    choiceTracker = choiceTrackerHeap2;
                } else if (selectionOfHeaps == MAX_LEGAL_HEAP) {
                    choiceTracker = choiceTrackerHeap3;
                }

                // logic to print how many coins a player can choose based on previous player's choice.
                if (2 * choiceTracker <= workingHeap) {
                    System.out.print("Now choose a number of coins between 1 and " + (2 * choiceTracker) + ": ");
                    while (!playerInput.hasNextInt()) {
                        playerInput.nextLine();
                        System.out.println("Sorry you must enter an integer.");
                        System.out.print("Now choose between 1 and " + (2 * choiceTracker) + ": ");
                    }
                    chosenCoins =playerInput.nextInt();
                } else if (2 * choiceTracker > workingHeap) {
                    System.out.print("Now choose a number of coins between 1 and " + workingHeap + ": ");
                    while (!playerInput.hasNextInt()) {
                        playerInput.nextLine();
                        System.out.println("Sorry you must enter an integer.");
                        System.out.print("Now choose between 1 and " + workingHeap + ": ");
                    }
                    chosenCoins =playerInput.nextInt();
                }
            }

            // Subtracting chosenCoins from the respected heap.
            if (selectionOfHeaps == 1) {
                heaps1 = heaps1 - chosenCoins;
            } else if (selectionOfHeaps == 2) {
                heaps2 = heaps2 - chosenCoins;
            } else if (selectionOfHeaps == MAX_LEGAL_HEAP) {
                heaps3 = heaps3 - chosenCoins;
            }

            // Tracking player choice for future use.
            if (selectionOfHeaps == 1) {
                choiceTrackerHeap1 = chosenCoins;
            } else if (selectionOfHeaps == 2) {
                choiceTrackerHeap2 = chosenCoins;
            } else if (selectionOfHeaps == MAX_LEGAL_HEAP) {
                choiceTrackerHeap3 = chosenCoins;
            }


            // When all heaps are zero, do-while loop will end.
            if (heaps1 == 0 && heaps2 ==0 && heaps3 == 0) {
                heapsNot0 = false;
                winner = player;
            }
            // Switching players.
            if (player == 1) {
                player = 2;
            } else if (player == 2) {
                player = 1;
            }
            playerInput.nextLine();
        } while (heapsNot0);

        // Printing winner.
        System.out.println("Player " + winner+ " wins!");
    }
}