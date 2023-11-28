package Others.practice.conversions;

import java.util.Scanner;

public class conv_dec_bin {
    public static void main(String[] args) {
        int num,num2;
        int j,c=0,quo,fin=0;
        int[] rem = new int[100];
        Scanner sc = new Scanner(System.in);
        System.out.print("DECIMAL : ");
        num = sc.nextInt();
        num2=num;
         while(num2 >= 1){
             num2=num2/2;
             c+=1;
         }
        for(j=1;j<=c;j++){
            rem[j]=num%2; //remainder
            quo   =num/2; //quotient
            num   =quo;   //new dividend = quotient of the previous dividend
        }
        for(j=c;j>=1;j--){  // array[] int to single int, explanation below.
          fin = fin*10;
          fin = fin+rem[j];
        }
        System.out.print("BINARY  : "+fin);
    }
}
/*     Converting decimal to binary:

       Division
        by 2	Quotient  Remainder

        (Digit)	                    Bit #
        (89)/2	  4         1	      0
        (44)/2	  22	    0         1
        (22)/2	  11	    0         2
        (11)/2	  5	        1	      3
        (5)/2	  2	        1	      4
        (2)/2	  1	        0         5
        (1)/2	  0	        1	      6

               binary = (1011001) base2


Converting array int to single int:


Start with a result of 0. Loop through all elements of your int array.
Multiply the result by 10, then add in the current number from the array.
At the end of the loop, you have your result.

Result: 0
Loop 1: Result * 10 => 0, Result + 1 => 1
Loop 2: Result * 10 => 10, Result + 2 => 12
Loop 3: Result * 10 >= 120, Result + 3 => 123
        */