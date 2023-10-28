package C2Basics;
import java.util.Scanner;

// Handling specific Exceptions
// In java, we can handle specific exceptions by typing 'multiple catch blocks'.
public class ch15_2_handling_specific_exceptions {
    public static void main(String[] args) {

        int [] marks = new int[3];
        marks[0] = 7;
        marks[1] = 56;
        marks[2] = 6;
        //marks[3] = 11; // error out of index
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array index");
        int ind = sc.nextInt();

        System.out.println("Enter the number you want to divide the value with");
        int number = sc.nextInt();
        try{
            System.out.println("The value at array index entered is: " + marks[ind]);
            System.out.println("The value of array-value/number is: " + marks[ind]/number);
        }
        catch (ArithmeticException e){ // catch block 1 (e.g. division by zero)
            System.out.println("ArithmeticException occurred!");
            System.out.println("\n"+e);
        }
        catch (ArrayIndexOutOfBoundsException e){ // catch block 2 (if user input a wrong index)
            System.out.println("ArrayIndexOutOfBoundsException occurred!");
            System.out.println("\n"+e);
        }
        catch (Exception e){ // catch block 3 (all other exceptions)
            System.out.println("Some other exception occurred!");
            System.out.println("\n"+e);
        }
    }
}
