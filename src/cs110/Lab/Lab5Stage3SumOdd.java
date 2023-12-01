package cs110.Lab;

// Write a program that calculates the sum of odd numbers from 1 up to and
// including 19 using a loop - that is, 1 + 3 + 5 + … + 15 + 17 + 19.
public class Lab5Stage3SumOdd {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 20; i++ ) {
            //System.out.println(i);
            sum = sum + i;
            i += 1;
        }
        System.out.println(sum);
    }
}
