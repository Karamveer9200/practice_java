package C2Basics;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ch15_3_nested_try_catch {
    public static void main(String[] args) {
        int number;
        boolean valid_input = true;

        while (valid_input) { // while loop will keep repeating until user input correct input

            try { // initial try
                System.out.println("\nEnter a number to divide 50: ");
                Scanner dc = new Scanner(System.in);

                // number = dc.nextInt(); // if written 'outside' try block, InputMismatchException won't be caught

                //'nested' try and catch for handling input exceptions
                try {
                    number = dc.nextInt();
                    System.out.println("The answer is :" + 50/number);
                    valid_input = false; // will end the loop

                }// these two types of exceptions can be handled inside the nested try
                catch (ArithmeticException e) { // if division by zero, etc.
                    System.out.println("ArithmeticException occurred!");
                    System.out.println(e);
                }
                catch (InputMismatchException e) { //for wrong datatype
                    System.out.println("Invalid input!");
                    // dc.nextLine(); will consume the invalid input, to avoid infinite loop
                    dc.nextLine();
                }

            } catch (Exception e) { // initial catch (if exception is not caught inside the nested try-catch block)
                System.out.println("Exception not caught by nested block!");
                System.out.println(e);
            }

            System.out.println("\nEnd of the program");
        }

    }
}
