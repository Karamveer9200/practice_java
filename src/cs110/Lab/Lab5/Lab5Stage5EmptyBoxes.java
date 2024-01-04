package cs110.Lab.Lab5;
/*
Repeat the task 4 but print a box of *s instead. E.g.
   1
********
*      *
*      *
*      *
********
   2
This - done in a straightforward way - needs four loops in total.
 */

import java.util.Scanner;

public class Lab5Stage5EmptyBoxes {
    public static void main(String[] args) {
        int length, height;
        Scanner sc = new Scanner(System.in);
        System.out.print("length: ");
        length = sc.nextInt();
        System.out.print("height: ");
        height = sc.nextInt();
        // for length side 1
        for (int j = 0; j < length; j++) {
            System.out.print("*");
        }
        System.out.print("\n");
        // for in between empty boxes
        for (int i = 0; i < height - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < length - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.print("\n");
        }
        // for length side 2
        for (int j = 0; j < length; j++) {
            System.out.print("*");
        }
    }
}
