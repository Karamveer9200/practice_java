package cs110.Lab.Lab3;

public class ForTesting {
    public static void main(String[] args) {
        int valueA = 70;
        int valueB = 25;

        int a = valueA;
        int b = valueB;
        while(b !=0 ) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("Greatest common divisor of " +
                valueA + " and " + valueB + " is " + a);
        }

    }

