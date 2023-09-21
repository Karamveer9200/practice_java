package OOPs_java.basics;

// Exceptions in Java:
//An exception is an event that occurs when a program is executed dissented the normal flow of instructions.
//There are mainly two types of exceptions in java:
//1) Checked exceptions - compile-time exceptions (Handled by the compiler)
//2) Unchecked exceptions - Runtime exceptions

//Commonly Occurring Exceptions
//Following are few commonly occurring exceptions in java:
//1) Null pointer exception
//2) Arithmetic Exception
//3) Array Index out of Bound exception
//4) Illegal Argument Exception (e.g. parameter accepts int, argument passed is string)
//5) Number Format Exception

// To handle exceptions, and to 'continue' our program, we use 'try and catch' block

import java.util.Scanner;

public class ch15_1_try_and_catch_block {
    public static void main(String[] args) {

        int a;
        int b;
        long c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number a:");
        a = sc.nextInt();
        System.out.println("Enter number b:");
        b = sc.nextInt();
        // if we don't use try catch block, exception will end the program, and 'end of the program' won't be printed
        try{
            c=a/b;
            System.out.println("a/b = "+c);
        }
        catch(Exception abc){
            // e.g. if we try to divide a by zero
            System.out.print("We failed to divide the number, Reason : ");
            System.out.println(abc);
            // The Program will continue execution, even after exception
        }

        System.out.println("\nEnd of the program, PRINTED");

    }
}
// --- IMPORTANT ---
// 'try' block cannot function alone, it must be used with 'catch' or 'finally' block
