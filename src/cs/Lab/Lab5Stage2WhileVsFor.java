package cs.Lab;

import java.util.Scanner;
//n this example, we are using a for loop when we should be using a while loop
// - convert the loop to a while loop.
public class Lab5Stage2WhileVsFor {
    public static void main(String[] args) {
        /* Count the number of times a user enters a number, until they enter the number 50 */
        Scanner in = new Scanner(System.in);
        int count = 0;
        int i = 0;
        //for(int i = 0; count != 50; i++) {
        while(count != 50) {
            System.out.print("Enter a number: ");
            count = in.nextInt();
            System.out.println(i);
            i++;
        }
        //}
        System.out.println("Finished");

    }
}
