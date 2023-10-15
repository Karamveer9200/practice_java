package C2_OOPS_and_Basics;

import java.util.Scanner;

public class ch6_practice {
    public static void main(String[] args) {
//----------------------------------------------------------
        // problem 1 - create an array of 5 floats and calc their sum

//        float sum =0;
//        float[] num = new float[5];
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("ENTER 5 NUMBERS");
//        for (int i=0; i<=4; i++) {
//            num[i]= sc.nextFloat();
//            sum=sum+num[i];
//        }
//        System.out.println("sum of is "+sum);
//

//----------------------------------------------------------
        // problem 2 - find-out weather a given integer is present in an array or not

//        int[] numbers = {1,2,3,4,5,6};
//
//        boolean is_in_array = false; //has to be initialized as t or f
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number to check");
//        int check = sc.nextInt();
//
//        for (int number : numbers) {
//            if (check == number) {
//                is_in_array = true;
//                break;
//            }
//        }
//        if(is_in_array) {
//            System.out.println("The value is present in the array");
//        }
//        else{
//            System.out.println("The value not found in the array");
//        }

//----------------------------------------------------------
        // problem 3 - calculate average marks of 5 students

//        float sum=0,average;
//        float[] num = new float[5];
//        Scanner sc = new Scanner(System.in);
//
//
//        for (int i=0; i<num.length; i++) {  // *array indexing always starts from 0 not 1, otherwise it will go out of bounds
//            System.out.printf("ENTER marks of student %d", i);
//            System.out.println("");
//            num[i]= sc.nextFloat();
//            sum=sum+num[i];
//            System.out.println("");
//        }
//        average = sum/5;
//        System.out.println("average of is "+average);

//----------------------------------------------------------
        // problem 4 - add two matrices of size 2x3
//
//        int[][] m1= new int[2][3];
//        int[][] m2= new int[2][3];
//        int[][] sum= new int[2][3];
//
//        // matrix 1 (input)
//        Scanner sc = new Scanner(System.in);
//        for (int i=0; i<m1.length; i++) {
//            System.out.println("Enter the elements of row "+(i+1));
//            for (int j=0; j<m1[i].length; j++) {
//                m1[i][j]=sc.nextInt();
//            }
//        }
//        // Display
//        System.out.println("Elements of matrix 1");
//        for (int i=0; i<m1.length; i++) {
//            for (int j=0; j<m1[i].length; j++) {
//                System.out.print(" "+m1[i][j]);
//            }
//            System.out.println("");
//        }
//        // matrix 2 (input)
//        for (int i=0; i<m2.length; i++) {
//            System.out.println("Enter the elements of row "+(i+1));
//            for (int j=0; j<m1[i].length; j++) {
//                m2[i][j]=sc.nextInt();
//            }
//        }
//        // Display
//        System.out.println("Elements of matrix 2");
//        for (int i=0; i<m2.length; i++) {
//            for (int j=0; j<m2[i].length; j++) {
//                System.out.print(" "+m2[i][j]);
//            }
//            System.out.println("");
//        }
//
//        // adding two of them
//        for (int i=0; i<m1.length; i++) {
//            for (int j=0; j<m1[i].length; j++) {
//                sum[i][j]= m1[i][j] + m2[i][j];
//            }
//        }
//        // Display
//        System.out.println("");
//        System.out.println("Sum of matrix 1 & 2");
//        for (int i=0; i<m2.length; i++) {
//            for (int j=0; j<m2[i].length; j++) {
//                System.out.print(" "+sum[i][j]);
//            }
//            System.out.println("");
//        }

//----------------------------------------------------------
        // problem 5 - reverse an array (2 arrays)
        // way 1

//        int[] num = new int[5];
//        int[] temp= new int[5];
//        int rev = num.length;
//        Scanner sc = new Scanner(System.in);
//
//
//        System.out.println("ENTER 5 integers in an array");
//        for (int i=0; i<num.length; i++) {  // *array indexing always starts from 0 not 1, otherwise it will go out of bounds
//            num[i]= sc.nextInt();
//            temp[rev]= num[i];
//            rev--;
//        }
//        System.out.println("Reversed array");
//        for (int i=0; i<num.length; i++) {
//            System.out.print(" "+temp[i]);
//        }

        // way 2 (reversing the same array)
//        int[] arr = new int[5];
//        int temp;
//        Scanner sc = new Scanner(System.in);
//        //Input
//        System.out.println("ENTER 5 integers in an array");
//        for (int i=0; i<arr.length; i++) {  // *array indexing always starts from 0 not 1, otherwise it will go out of bounds
//            arr[i]= sc.nextInt();
//        }
//
//        // finding midpoint of an array
//        int mid = Math.floorDiv(arr.length, 2); // this fun will give the highest value integer
//        int l = arr.length;
//
//        // swapping
//        for (int i=0; i<mid; i++) {
//            //* swap a[i] and a[l-1-i]  till midpoint of the array
//            //  a    b   temp
//            // | |  |4|   |3|
//            //  \---->----/
//            temp = arr[i];
//            arr[i] = arr[l-1-i]; // 5-1-0 = 4 : arr[4]->last element
//            arr[l-1-i] = temp;
//        }
//        System.out.println("length "+l);
//        System.out.println("Reversed array");
//        for (int i=0; i<arr.length; i++) {
//            System.out.print(" " + arr[i]);
//        }


//----------------------------------------------------------
        // problem 6 - finding the biggest element in an array
//
//        int[] arr = new int[5];
//        int max=Integer.MIN_VALUE;
//        Scanner sc = new Scanner(System.in);
//        //Input
//        System.out.println("ENTER 5 integers in an array");
//        for (int i=0; i<arr.length; i++) {  // *array indexing always starts from 0 not 1, otherwise it will go out of bounds
//            arr[i]= sc.nextInt();
//        }
//
//        // Finding the biggest number
//        for (int len : arr) {
//            if (len>max) {
//                max=len;
//            }
//        }
//        System.out.println("The biggest integer is "+max);


//----------------------------------------------------------
        // problem 6 - finding the smallest element in an array

//        int[] arr = new int[5];
//
//        Scanner sc = new Scanner(System.in);
//        //Input
//        System.out.println("ENTER 5 integers in an array");
//        for (int i=0; i<arr.length; i++) {  // *array indexing always starts from 0 not 1, otherwise it will go out of bounds
//            arr[i]= sc.nextInt();
//        }
//
//        // Finding the biggest number
//        int min= Integer.MAX_VALUE; // fun. gives the maximum value possible for int
//        for (int len : arr) {
//            if (len<min) {
//                min=len;
//            }
//        }
//        System.out.println("The smallest integer is "+min);

//----------------------------------------------------------
        // problem 7 - Check if the array is sorted or not

        int[] arr = new int[5];

        //Input
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER 5 integers in an array");
        for (int i = 0; i < arr.length; i++) {  // *array indexing always starts from 0 not 1, otherwise it will go out of bounds
            arr[i] = sc.nextInt();
        }

        // Checking if the array is sorted
        // sorted  = {1,2,3,4,5}
        // unsorted = {3,4,5,1,2}
        boolean issoted = true;
        for (int i = 0; i < arr.length-1; i++) {
            // length-1 .: arr[i+1] will go out of bound as there is no 6th element
            if (arr[i] > arr[i + 1]) {
                issoted = false;
                break;
            }
        }
        if (issoted) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }
}
