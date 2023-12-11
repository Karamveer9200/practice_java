package cs110.class_test;

import java.util.ArrayList;

public class Numbers {
    public static void main(String[] args) {

        System.out.println(isPrime(12));
        System.out.println(isPrime(23));

        System.out.println(isPythagoreanTriple(3, 4, 5));
        System.out.println(isPythagoreanTriple(3,5,2));

        fibonacciNum(1133);
    }
    static boolean isPrime(int n) {
        if (n < 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPythagoreanTriple(int a, int b, int c) {
        if (a*a + b*b == c*c) {
            return true;
        }
        return false;
    }

    static void fibonacciNum(long limit) {
        ArrayList<Long> fib = new ArrayList<>();
        fib.add(1L);
        fib.add(2L);
        long f1 = 1;
        long f2 = 2;
        while (f2 < limit) {
            long temp = f2;
            f2 += f1;
            fib.add(f2);
            f1 = temp;
        }

        System.out.println(fib);
    }

}



