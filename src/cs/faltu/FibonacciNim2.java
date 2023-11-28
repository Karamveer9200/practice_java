package cs.faltu;
import java.util.Scanner;

public class FibonacciNim2 {

    private static final int INITIAL_HEAP_SIZE = 13;
    private static final int MAX_HEAP_SELECT = 3;
    private static int[] heaps = {INITIAL_HEAP_SIZE, INITIAL_HEAP_SIZE, INITIAL_HEAP_SIZE};

    // initial active player is 1
    private static int activePlayer = 1;


    public static void main(String[] args) {

        int selectedHeap;
        int coinsTaken;
        int activeHeap;
        // boolean value for while loop
        boolean heapsHaveCoins = true;
        int lastPick = 0;
        int[] coinHistory = new int[MAX_HEAP_SELECT];

        Scanner sc = new Scanner(System.in);

        // Main game loop
        do {
            displayRemainingCoins();

            System.out.print("Player " + activePlayer + ": choose a heap: ");
            selectedHeap = getPlayerInput(sc);

            activeHeap = getActiveHeap(selectedHeap);

            if (activeHeap == INITIAL_HEAP_SIZE) {
                coinsTaken = getCoinsFirstTime(sc, activeHeap);
            } else {
                int index = selectedHeap - 1;
                coinsTaken = getCoins(sc, activeHeap, coinHistory[index]);
            }

            updateHeapAndChoiceTracker(selectedHeap, coinsTaken, coinHistory);

            if (heapStatus()) {
                heapsHaveCoins = false;
                lastPick = activePlayer;
            }

            activePlayer = switchPlayer(activePlayer);
        } while (heapsHaveCoins);

        // Displaying the winner
        System.out.println("Player " + lastPick + " wins!");
    }

    // Displays the remaining coins in each heap
    private static void displayRemainingCoins() {
        System.out.println("Remaining coins: " + heaps[0] + ", " + heaps[1] + ", " + heaps[2]);
    }

    // Gets the player's input for choosing a heap
    private static int getPlayerInput(Scanner playerInput) {
        int selectedHeap;
        while (!playerInput.hasNextInt()) {
            playerInput.nextLine();
            System.out.println("Invalid input. Please enter an integer in the range 1 to " + MAX_HEAP_SELECT + ".");
            System.out.print("Player " + activePlayer + ": choose a heap: ");
        }
        selectedHeap = playerInput.nextInt();
        return selectedHeap;
    }

    // Retrieves the current size of the selected heap
    private static int getActiveHeap(int selectedHeap) {
        return (selectedHeap >= 1 && selectedHeap <= MAX_HEAP_SELECT) ? heaps[selectedHeap - 1] : 0;
    }

    // Handles the case when the player chooses a heap with its initial size
    private static int getCoinsFirstTime(Scanner playerInput, int workingHeap) {
        int coinsTaken;
        playerInput.nextLine();
        System.out.print("Now choose a number of coins between 1 and " + (workingHeap - 1) + ": ");
        coinsTaken = getPlayerInput(playerInput);
        return coinsTaken;
    }

    // Handles the case when the player chooses a heap with a reduced size
    private static int getCoins(Scanner playerInput, int workingHeap, int choiceTracker) {
        int coinsTaken;
        int maxCoins = Math.min(workingHeap, 2 * choiceTracker);
        System.out.print("Now choose a number of coins between 1 and " + maxCoins + ": ");
        coinsTaken = getPlayerInput(playerInput);
        return coinsTaken;
    }

    // Updating the heap size and choice tracker based on current player's move
    private static void updateHeapAndChoiceTracker(int selectedHeap, int coinsTaken, int[] choiceTracker) {
        int index = selectedHeap - 1;
        heaps[index] -= coinsTaken;
        choiceTracker[index] = coinsTaken;
    }

    // Checking if all heaps are empty or not
    private static boolean heapStatus() {
        return heaps[0] == 0 && heaps[1] == 0 && heaps[2] == 0;
    }

    // Switching the current player
    private static int switchPlayer(int activePlayer) {
        return (activePlayer == 1) ? 2 : 1;
    }
}