package com.exercise_5.shape;

import java.util.Scanner;

public class Square{
   
    //int length; // --ERROR: can't access because no object creation
    // So, we have to make them 'static' to make then accessible to this class 
    // default variable, So can only be accessed within this package
    static int length;


        // area method
        // public int area(){ // --ERROR: can't access because 'no object creation'
        // So, we have to make it static to make it accessible to this class
        static int area(){
            return length * length;
        }

        // setters for length 
        static void set_Len(int l){
            // this.length = length; cannot use 'this.' since 'no object creation'
            // is happening in the main method
            length = l;
        }
        


        public static void main(String[] args){
            int l ;
      
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the side");
            l = sc.nextInt();
            set_Len(l);
            
            System.out.println("area of square is "+area()+"m/sq");
        }

}
