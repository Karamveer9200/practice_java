package CS_110.Exercises;

/*
Write a for loop that prints out the numbers 1 to 100. For all numbers that are multiples of 3 it should also print
 “fizz”, for multiples of 5 it should print “buzz” and for multiples of both it should print “fizzbuzz”. This is a
 common interview question for programmers and should be easy but an alarming % of “programmers” at the interview
 can’t do it.
 */
public class Ch6Ex4Multipliers {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println(i);
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println(i);
                System.out.println("buzz");

            }
        }
    }
}
