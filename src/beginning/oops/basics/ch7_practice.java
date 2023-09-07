package beginning.oops.basics;

import java.util.Scanner;

public class ch7_practice {
//----------------------------------------------------------
// Problem 1 - method to print multiplication table of a number n

//    static void table(int a){
//        for (int i=1; i<=10; i++) {
//        System.out.printf("%d X %d = %d \n",a , i, a*i);
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number to print table");
//        int n = sc.nextInt();
//        table(n);
//    }

//----------------------------------------------------------
// Problem 2 - pattern
    // *
    // **
    // ***
    // ****

//    static void pattern(){
//        for (int i=0; i<4 ;i++) {
//            for (int j=0; j<=i; j++) {
//                System.out.print(" * ");
//            }
//            System.out.println("");
//        }
//    }
//
//    public static void main(String[] args) {
//        pattern();
//    }

//----------------------------------------------------------
// Problem 3 - recursive method to print the sum of first n natural numbers

//    static int sum(int a){
//        if (a==0){
//            return 0;
//        } else if (a==1) {
//            return 1;
//        }
//        return a + sum(a-1);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the value of n ");
//        int n = sc.nextInt();
//        int s = sum(n);
//        System.out.printf("sum of first %d natural numbers is %d",n, s);
//    }

//----------------------------------------------------------
// Problem 4 - pattern
    // ****
    // ***
    // **
    // *
//        static void pattern(){
//        for (int i=4; i>0 ;i--) {
//            for (int j=i; j>0; j--) {
//                System.out.print(" * ");
//            }
//            System.out.println("");
//        }
//    }
//
//    public static void main(String[] args) {
//        pattern();
//    }

//----------------------------------------------------------
// Problem 5 - print nth term of a fibonacci series using recursion
// fibonacci series - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34

//    static int fib(int n) {
//        /* if(n==1){
//            return 0;
//        }
//        else if(n==2){
//            return 1;
//        } */
//        if (n == 1 || n == 2) {
//            return n - 1;
//        } else {
//            return fib(n - 1) + fib(n - 2);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the value of n ");
//        int n = sc.nextInt();
//        System.out.printf("%dth term of a fibonacci series is %d",n, fib(n));
//
//    }

//----------------------------------------------------------
// Problem 6 - function to find average of a set of numbers passed as arguments

//    static float average(int ... set){
//        float avg = 0;
//        for(float arr: set){
//            avg +=arr;
//        }
//        return avg/set.length;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Average is "+average(3,4,3,3,4));
//    }

//----------------------------------------------------------
// Problem 7 - repeat problem 2 using recursion
//    static void pattern_rec(int n){
//        if(n>0) {
//            pattern_rec(n-1);
//            for (int i = 0; i < n; i++) {
//                System.out.print(" * ");// all the lines will be printed only after the value of n reaches 1
//                // **** will be printed at the last before that pattern_rec(n-1) will print *** and so on.
//            }
//            System.out.println("");
//        }
//    }
//
//    public static void main(String[] args) {
//        pattern_rec(4);
//    }

//----------------------------------------------------------
// Problem 8 - repeat problem 4 using recursion

    static void pattern_rec(int n){ // solution needed
        int a = 1;
        if(n>0 && a<n) {
            pattern_rec(a+1);
            for (int i = a; i > 0; i--) {
                System.out.print(" * ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        pattern_rec(4);
    }
}