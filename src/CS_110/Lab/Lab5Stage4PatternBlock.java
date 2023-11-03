package CS_110.Lab;

/*
Write a program that accepts reads two integers from the user - one representing
length and one representing height. It should then print out a square of *s length
wide and height deep. E.g. if length is 8 and height is 5:
  ********
  ********
  ********
  ********
  ********
 */

import java.util.Scanner;

public class Lab5Stage4PatternBlock {
    public static void main(String[] args) {
        int length, height;
        Scanner sc = new Scanner(System.in);
        System.out.print("length: ");
        length = sc.nextInt();
        System.out.print("height: ");
        height = sc.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

