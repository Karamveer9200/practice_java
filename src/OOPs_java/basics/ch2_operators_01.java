package OOPs_java.basics;

import java.util.Scanner;

public class ch2_operators_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        double a = sc.nextDouble();
        System.out.println("Enter the second number");
        double b = sc.nextDouble();
        System.out.println(a>b);
        System.out.println(b>a);


    }
}
