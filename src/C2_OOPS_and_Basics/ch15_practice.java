package C2_OOPS_and_Basics;

import java.util.InputMismatchException;
import java.util.Scanner;

// using multiple custom exceptions

public class ch15_practice {

    // method to implement logic with multiple custom exceptions
    // if we don't mention throws keyword, the code will still work
    public static void divide() {
    //public static void divide() throws EasterEgg1, EasterEgg2 { // preferred way to write (easy to understand)
        int number;
        int answer;
        int tries = 0;


        Scanner sc = new Scanner(System.in);
        while (tries<5) {
            try {
                System.out.println("\nEnter a number to divide 1000 by ");
                number = sc.nextInt();

                // trying our eater-egg exceptions , when user enter 420 or 666
                if (number == 420) {
                    try {
                        throw new EasterEgg1();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else if (number == 666) {
                    try {
                        throw new EasterEgg2();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    answer = 1000 / number;
                    System.out.println("Answer is : " + answer);
                    break;
                }
            } catch (ArithmeticException e) {
                System.out.println("HaHa");
                System.out.println("Tries left : " + (5 - tries));
            } catch (InputMismatchException e) {
                // sc.nextLine(); will consume the invalid input, to avoid infinite loop
                sc.nextLine();
                System.out.println("HeHe");
                System.out.println("Tries left : " + (5 - tries));
            } catch (Exception e) {
                System.out.println("HoHo");
                System.out.println("Tries left : " + (5 - tries));
            } finally {
                System.out.println("\ncleaning the memory ...");
            }
            tries++;
        }
    }

    //  using the method divide()
        public static void main(String[] args)  {
       // public static void main(String[] args) throws EasterEgg1, EasterEgg2 { //(preferred way to write)
        divide();
        }

}

// custom exception1
class EasterEgg1 extends Exception{
    @Override
    public String toString(){
        return "NICE ;) ";
    }
}

// custom exception2
class EasterEgg2 extends Exception{
    @Override
    public String toString(){
        return "DEVIL";
    }
}
