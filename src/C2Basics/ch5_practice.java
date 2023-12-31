package C2Basics;
 import java.util.Scanner;

public class ch5_practice {
    public static void main(String[] args) {
//----------------------------------------------------------
// practise problem 1 - pattern
//        ****
//        ***
//        **
//        *
//----------------------------------------------------------
//        for (int i = 4; i > 0; i--) {
//            for (int j = 0; j < i; j++) { // when i=4, j=4 and so on...
//             // ... or for(int j=1; j<=i; j++) same thing
//                System.out.print("*");
//            }
//            System.out.println("\n");
//        }

//----------------------------------------------------------
// practise problem 2 - sum of first n even numbers
//----------------------------------------------------------
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the value of n");
//        int n = sc.nextInt();
//
//        int sum=0;
//        for(int i=1; i<=2*n; i++){
//            // if we want to sum fist 3 even numbers, we have to run loop 6 times to if we start from 1
//            // hence, we doubled the input value
//            if(i%2==0){// if even then add to sum
//                sum=sum+i;
//            }
//        }
//        System.out.println("sum of first "+n+" even numbers is: "+sum);

//----------------------------------------------------------
// practise problem 3 - Multiplication table of n
//----------------------------------------------------------
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the value of n");
//        int n = sc.nextInt();
//
//        for(int i=0; i<=10; i++){
//            System.out.printf("\n%d X %d = %d",n,i,n*i);// if using %d(c lang) use 'printf'
//        }

//----------------------------------------------------------
// practise problem 4 - Multiplication table of n in reverse
//----------------------------------------------------------
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the value of n");
//        int n = sc.nextInt();
//
//        for(int i=10; i>=0; i--){
//            System.out.printf("\n%d X %d = %d",n,i,n*i);// if using %d(c lang) use 'printf'
//        }
//
//----------------------------------------------------------
// practise problem 5 - factorial of n numbers using while loop
//----------------------------------------------------------
//        factorial 5!= 1x2x3x4x5

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n");
        int n = sc.nextInt();
        int i = 1;
        int fact =1;

        do {
            fact = fact*i;
            i++;
        }
        while (i<=n);
        System.out.printf("factorial of %d (%d!) is %d",n ,n, fact);

    }
}
